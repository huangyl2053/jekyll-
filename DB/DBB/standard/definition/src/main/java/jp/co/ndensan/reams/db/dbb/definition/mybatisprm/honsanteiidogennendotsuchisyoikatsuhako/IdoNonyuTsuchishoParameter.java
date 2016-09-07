/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidogennendotsuchisyoikatsuhako;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納入通知書情報検索用パラメータクラスです。
 *
 * @reamsid_L DBB-0880-040 xicongwang
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdoNonyuTsuchishoParameter {

    private final int 出力期;
    private final RString 口座区分;
    private final RString 処理対象;
    private final RString 通知書プリント条件;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 出力期 int
     * @param 口座区分 RString
     * @param 処理対象 RString
     * @param 通知書プリント条件 RString
     * @param 出力順 RString
     */
    private IdoNonyuTsuchishoParameter(
            int 出力期,
            RString 口座区分,
            RString 処理対象,
            RString 通知書プリント条件,
            RString 出力順) {
        this.出力期 = 出力期;
        this.口座区分 = 口座区分;
        this.処理対象 = 処理対象;
        this.通知書プリント条件 = 通知書プリント条件;
        this.出力順 = 出力順;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 出力期 int
     * @param 口座区分 RString
     * @param 処理対象 RString
     * @param 通知書プリント条件 RString
     * @param 出力順 RString
     * @return パラメータ
     */
    public static IdoNonyuTsuchishoParameter createSelectByKeyParam(
            int 出力期,
            RString 口座区分,
            RString 処理対象,
            RString 通知書プリント条件,
            RString 出力順) {
        return new IdoNonyuTsuchishoParameter(出力期, 口座区分, 処理対象, 通知書プリント条件, 出力順);
    }

}
