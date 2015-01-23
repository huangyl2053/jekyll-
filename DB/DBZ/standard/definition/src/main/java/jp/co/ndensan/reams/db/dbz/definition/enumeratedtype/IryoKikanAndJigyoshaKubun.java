/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者番号の3桁目によって判断される、医療機関と介護保険事業者を表す区分です。
 *
 * @author n8178 城間篤人
 */
public enum IryoKikanAndJigyoshaKubun {

    /**
     * 医科であることを示します。
     */
    医科("1", "医科", true),
    /**
     * 歯科であることを示します。
     */
    歯科("3", "歯科", true),
    /**
     * 薬局であることを示します。
     */
    薬局("4", "薬局", true),
    /**
     * 老人保健施設であることを示します。
     */
    老人保健施設("5", "老人保健施設", true),
    /**
     * 訪問看護ステーションであることを示します。
     */
    訪問看護ステーション("6", "訪問看護ステーション", true),
    /**
     * 地域包括支援センターであることを示します。
     */
    地域包括支援センター("0", "地域包括支援センター", false),
    /**
     * 介護予防・日常生活支援総合事業事業所であることを示します。
     */
    介護予防_日常生活支援総合事業事業所("0", "介護予防・日常生活支援総合事業事業所", false),
    /**
     * 指定事業所であることを示します。
     */
    指定事業所("7", "指定事業所", false),
    /**
     * 基準該当事業所であることを示します。
     */
    基準該当事業所("8", "基準該当事業所", false),
    /**
     * 地域密着型サービス事業所であることを示します。
     */
    地域密着型サービス事業所("9", "地域密着型サービス事業所", false);

    private final RString kubunCode;
    private final RString kubunName;
    private final boolean isIryoKikan;

    private IryoKikanAndJigyoshaKubun(String kubunCode, String kubunName, boolean isIryoKikan) {
        this.isIryoKikan = isIryoKikan;
        this.kubunCode = new RString(kubunCode);
        this.kubunName = new RString(kubunName);
    }

    /**
     * 区分が、医療機関か否かを返します。
     *
     * @return 医療機関ならtrue
     */
    public boolean is医療機関() {
        return isIryoKikan;
    }

    /**
     * 区分の名称を取得します。
     *
     * @return 区分名称
     */
    public RString getName() {
        return kubunName;
    }

    /**
     * 引数から受け取った事業者番号を元に、医療機関区分もしくは事業者区分を返します。
     *
     * @param jigyoshaNo 事業者番号
     * @return 事業者番号に対応した、医療期間区分もしくは事業者の区分
     * @throws IllegalArgumentException 引数の事業者番号が、医療機関_事業者区分に変換できないとき
     */
    public static IryoKikanAndJigyoshaKubun toValue(JigyoshaNo jigyoshaNo) throws IllegalArgumentException {
        return toValue(jigyoshaNo.value());
    }

    /**
     * 引数から受け取った事業者番号を表す文字列を元に、医療機関区分もしくは事業者区分を返します。
     *
     * @param jigyoshaNo 事業者番号を表す文字列
     * @return 事業者番号に対応した、医療期間区分もしくは事業者の区分
     * @throws IllegalArgumentException 引数の事業者番号が、医療機関_事業者区分に変換できないとき
     */
    public static IryoKikanAndJigyoshaKubun toValue(RString jigyoshaNo) throws IllegalArgumentException {
        for (IryoKikanAndJigyoshaKubun kubun : values()) {
            if (!kubun.kubunCode.equals(jigyoshaNo.stringAt(2))) {
                continue;
            }

            if (kubun != 地域包括支援センター && kubun != 介護予防_日常生活支援総合事業事業所) {
                return kubun;
            }

            int jigyosha5_9Number = Integer.parseInt(jigyoshaNo.toString().substring(5, 9));
            if (kubun == 地域包括支援センター && jigyosha5_9Number <= 5000) {
                return kubun;
            }

            if (kubun == 介護予防_日常生活支援総合事業事業所 && 5001 <= jigyosha5_9Number) {
                return kubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業者番号は、事業者区分"));
    }

}
