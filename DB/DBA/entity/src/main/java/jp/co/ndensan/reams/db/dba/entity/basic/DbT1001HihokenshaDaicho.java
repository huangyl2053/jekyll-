/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 *
 * @author N3327 三浦 凌
 */
public enum DbT1001HihokenshaDaicho implements IColumnDefinition {

    /**
     * 市町村コード
     */
    ShichosonCd(5, 0),
    /**
     * 被保険者番号
     */
    HihokenshaNo(10, 0),
    /**
     * 識別コード
     */
    ShikibetsuCode(15, 0),
    /**
     * 資格異動区分コード
     */
    ShikakuIdouKubunCode(5, 0),
    /**
     * 資格異動届出年月日
     */
    ShikakuShutokuTodokedeDate(8, 0),
    /**
     * 資格取得事由コード
     */
    ShikakuShutokuJiyuCode(3, 0),
    /**
     * 資格取得年月日
     */
    ShikakuShutokuDate(8, 0),
    /**
     * 一号被保険者年齢到達年月日
     */
    IchigoHihokenshaNenreiTotatsuDate(8, 0),
    /**
     * 被保険者区分コード
     */
    HihokenshaKubunCode(1, 0),
    /**
     * 資格喪失事由コード
     */
    ShikakuSoshitsuJiyuCode(3, 0),
    /**
     * 資格喪失届出年月日
     */
    ShikakuSoshitsuTodokedeDate(8, 0),
    /**
     * 資格喪失年月日
     */
    ShikakuSoshitsuDate(8, 0),
    /**
     * 資格変更事由コード
     */
    ShikakuHenkoJiyuCode(3, 0),
    /**
     * 資格変更届出年月日
     */
    ShikakuHenkoTodokedeDate(8, 0),
    /**
     * 資格変更年月日
     */
    ShikakuHenkoDate(8, 0),
    /**
     * 住所地特例適用事由コード
     */
    JushochitokureiTekiyoJiyuCode(3, 0),
    /**
     * 住所地特例適用届出年月日
     */
    JushochitokureiTekiyoTodokedeDate(8, 0),
    /**
     * 住所地特例適用年月日
     */
    JushochitokureiTekiyoDate(8, 0),
    /**
     * 住所地特例解除事由コード
     */
    JushochitokureiKaijoJiyuCode(3, 0),
    /**
     * 住所地特例解除届出年月日
     */
    JushochitokureiKaijoTodokedeDate(8, 0),
    /**
     * 住所地特例解除年月日
     */
    JushochitokureiKaijoDate(8, 0),
    /**
     * 住所地特例フラグ
     */
    JushochitokureiFlag(1, 0),
    /**
     * 広域内住所地特例フラグ
     */
    KoikinaiJushochitokureiFlag(1, 0),
    /**
     * 広域内特例措置元市町村コード
     */
    KoikinaiTokureiSochimotoShichosonCd(5, 0),
    /**
     * 再交付区分
     */
    SaikofuKubun(1, 0),
    /**
     * 再交付事由コード
     */
    SaikofuJiyuCode(3, 0);
    private final int maxLength;
    private final int scale;

    private DbT1001HihokenshaDaicho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 最大長を取得します。
     *
     * @return 最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数を取得します。
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
}
