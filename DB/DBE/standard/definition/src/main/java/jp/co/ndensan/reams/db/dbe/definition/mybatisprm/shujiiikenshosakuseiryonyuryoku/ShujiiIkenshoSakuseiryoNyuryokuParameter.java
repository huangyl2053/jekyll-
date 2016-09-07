/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshosakuseiryonyuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成料入力のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIkenshoSakuseiryoNyuryokuParameter {

    private final int saidaiKensu;
    private final RString shichosonCode;
    private final boolean shichosonCodeFlg;
    private final boolean zenPouIttiFlg;
    private final boolean kanZenIttiFlg;
    private final boolean buBunIttiFlg;
    private final boolean kouHouIttiFlg;
    private final RString shujiiName;
    private final RString shichosonCode_hidden;
    private final RString shoKisaiHokenshaNo_hidden;
    private final RString shujiiCode;
    private final RString shujiiIryokikanCode;
    private final RString kensakuYMFrom;
    private final boolean kensakuYMFromFlg;
    private final RString kensakuYMTo;
    private final boolean kensakuYMToFlg;
    private static final RString KENSAKUJYOUKEN_ZENPOU = new RString("前方一致");
    private static final RString KENSAKUJYOUKEN_KANZEN = new RString("完全一致");
    private static final RString KENSAKUJYOUKEN_BUBUN = new RString("部分一致");
    private static final RString KENSAKUJYOUKEN_KOUHOU = new RString("後方一致");

    private ShujiiIkenshoSakuseiryoNyuryokuParameter(
            int saidaiKensu,
            RString shichosonCode,
            boolean shichosonCodeFlg,
            boolean zenPouIttiFlg,
            boolean kanZenIttiFlg,
            boolean buBunIttiFlg,
            boolean kouHouIttiFlg,
            RString shujiiName,
            RString shichosonCode_hidden,
            RString shoKisaiHokenshaNo_hidden,
            RString shujiiCode,
            RString shujiiIryokikanCode,
            RString kensakuYMFrom,
            boolean kensakuYMFromFlg,
            RString kensakuYMTo,
            boolean kensakuYMToFlg
    ) {
        this.saidaiKensu = saidaiKensu;
        this.shichosonCode = shichosonCode;
        this.shichosonCodeFlg = shichosonCodeFlg;
        this.zenPouIttiFlg = zenPouIttiFlg;
        this.kanZenIttiFlg = kanZenIttiFlg;
        this.buBunIttiFlg = buBunIttiFlg;
        this.kouHouIttiFlg = kouHouIttiFlg;
        this.shujiiName = shujiiName;
        this.shichosonCode_hidden = shichosonCode_hidden;
        this.shoKisaiHokenshaNo_hidden = shoKisaiHokenshaNo_hidden;
        this.shujiiCode = shujiiCode;
        this.shujiiIryokikanCode = shujiiIryokikanCode;
        this.kensakuYMFrom = kensakuYMFrom;
        this.kensakuYMFromFlg = kensakuYMFromFlg;
        this.kensakuYMTo = kensakuYMTo;
        this.kensakuYMToFlg = kensakuYMToFlg;
    }

    /**
     * 主治医情報のパラメータを生成します。
     *
     * @param saidaiKensu 最大表示件数
     * @param shichosonCode 市町村コード
     * @param shujiiName 主治医氏名
     * @param kensakuJyouken 検索条件
     * @return 主治医意見書作成料入力パラメータ
     */
    public static ShujiiIkenshoSakuseiryoNyuryokuParameter createParam主治医情報(
            int saidaiKensu,
            RString shichosonCode,
            RString shujiiName,
            RString kensakuJyouken) {
        boolean shichosonCodeFlg = false;
        boolean zenPouIttiFlg = false;
        boolean kanZenIttiFlg = false;
        boolean buBunIttiFlg = false;
        boolean kouHouIttiFlg = false;
        if (!RString.isNullOrEmpty(shichosonCode)) {
            shichosonCodeFlg = true;
        }
        if (!RString.isNullOrEmpty(shujiiName)) {
            if (KENSAKUJYOUKEN_ZENPOU.equals(kensakuJyouken)) {
                zenPouIttiFlg = true;
            } else if (KENSAKUJYOUKEN_KANZEN.equals(kensakuJyouken)) {
                kanZenIttiFlg = true;
            } else if (KENSAKUJYOUKEN_BUBUN.equals(kensakuJyouken)) {
                buBunIttiFlg = true;
            } else if (KENSAKUJYOUKEN_KOUHOU.equals(kensakuJyouken)) {
                kouHouIttiFlg = true;
            }
        }
        return new ShujiiIkenshoSakuseiryoNyuryokuParameter(
                saidaiKensu,
                shichosonCode,
                shichosonCodeFlg,
                zenPouIttiFlg,
                kanZenIttiFlg,
                buBunIttiFlg,
                kouHouIttiFlg,
                shujiiName,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                false,
                RString.EMPTY,
                false);
    }

    /**
     * 主治医実績一覧のパラメータを生成します。
     *
     * @param shichosonCode_hidden 市町村コード(hidden)
     * @param shoKisaiHokenshaNo_hidden 証記載保険者番号(hidden)
     * @param shujiiCode 主治医コード
     * @param shujiiIryokikanCode 主治医医療機関コード
     * @param kensakuYMFrom 検索年月FROM
     * @param kensakuYMTo 検索年月TO
     * @return 主治医意見書作成料入力パラメータ
     */
    public static ShujiiIkenshoSakuseiryoNyuryokuParameter createParam主治医実績一覧(
            RString shichosonCode_hidden,
            RString shoKisaiHokenshaNo_hidden,
            RString shujiiCode,
            RString shujiiIryokikanCode,
            RString kensakuYMFrom,
            RString kensakuYMTo) {
        boolean kensakuYMFromFlg = true;
        boolean kensakuYMToFlg = true;
        if (RString.isNullOrEmpty(kensakuYMFrom)) {
            kensakuYMFromFlg = false;
        }
        if (RString.isNullOrEmpty(kensakuYMTo)) {
            kensakuYMToFlg = false;
        }
        return new ShujiiIkenshoSakuseiryoNyuryokuParameter(
                0,
                RString.EMPTY,
                false,
                false,
                false,
                false,
                false,
                RString.EMPTY,
                shichosonCode_hidden,
                shoKisaiHokenshaNo_hidden,
                shujiiCode,
                shujiiIryokikanCode,
                kensakuYMFrom,
                kensakuYMFromFlg,
                kensakuYMTo,
                kensakuYMToFlg);
    }
}
