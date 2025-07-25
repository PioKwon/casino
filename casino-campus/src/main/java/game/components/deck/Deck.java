package game.components.deck;

import game.components.card.Card;
import game.components.card.Rank;
import game.components.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 카드 덱을 나타내는 클래스
 * 
 * 이 클래스는 카드 게임에서 사용되는 카드 덱의 기본 동작을 정의합니다.
 * 표준 덱은 52장의 카드(4개 무늬 × 13개 랭크)로 구성됩니다.
 * 
 * <p>구현 요구사항:</p>
 * <ul>
 *   <li>새 덱은 52장의 카드를 모두 포함해야 합니다</li>
 *   <li>카드를 뽑으면 덱에서 제거되어야 합니다</li>
 *   <li>셔플은 카드의 순서를 무작위로 섞어야 합니다</li>
 *   <li>한 번 사용한 덱은 폐기하고 새 덱을 생성해야 합니다</li>
 *   <li>적절한 예외 처리를 해야 합니다</li>
 * </ul>
 * 
 * <p>카지노 실무 규칙:</p>
 * <ul>
 *   <li>매 게임마다 새로운 덱 사용</li>
 *   <li>사용한 카드는 재사용하지 않음 (보안 및 공정성)</li>
 *   <li>카드 카운팅 방지를 위해 여러 덱을 함께 사용</li>
 *   <li>플라스틱 및 봉인된 새 덱 사용</li>
 * </ul>
 * 
 * <p>사용 예시:</p>
 * <pre>
 * // 매 게임마다 새 덱 생성
 * Deck deck = new Deck();
 * deck.shuffle();
 * 
 * // 게임 진행
 * Card card = deck.drawCard();
 * 
 * // 게임 종료 후 덱은 폐기
 * // 다음 게임을 위해 새 덱 생성 필요
 * deck = new Deck();
 * deck.shuffle();
 * </pre>
 * 
 * 구현이 필요한 부분:
 * - cards 필드 초기화: 52장의 카드 생성
 * - shuffle() 메서드: 카드 섞기
 * - drawCard() 메서드: 카드 한 장 뽑기
 * - isEmpty() 메서드: 덱이 비어있는지 확인
 * 
 * @author XIYO
 * @version 1.0
 * @since 2024-01-01
 */
public class Deck {

    private final List<Card> cards = new ArrayList<>();
    
    // 인스턴스 초기화 블록 - 52장의 카드 생성
    {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    
    /**
     * 덱을 섞습니다.
     * 
     * 카드의 순서를 무작위로 변경합니다.
     * 셔플 후에도 덱의 카드 수는 변하지 않습니다.
     * 
     * <p>카지노 규칙:</p>
     * 새로운 덱은 사용 전에 반드시 섞어야 합니다.
     */
    public void shuffle() {

        Collections.shuffle(cards);
    }
    
    /**
     * 덱에서 카드를 한 장 뽑습니다.
     * 
     * 덱의 맨 위에서 카드를 한 장 뽑아 반환합니다.
     * 뽑은 카드는 덱에서 제거됩니다.
     * 
     * @return 뽑은 카드
     * @throws IllegalStateException 덱이 비어있을 때
     */
    public Card drawCard() {

        if (isEmpty()) {
            throw new IllegalStateException("덱이 비어있습니다.");
        }
        return cards.remove(0);
    }
    
    /**
     * 덱이 비어있는지 확인합니다.
     * 
     * @return 덱이 비어있으면 true, 카드가 하나라도 있으면 false
     */
    public boolean isEmpty() {

        return cards.isEmpty();
    }
}