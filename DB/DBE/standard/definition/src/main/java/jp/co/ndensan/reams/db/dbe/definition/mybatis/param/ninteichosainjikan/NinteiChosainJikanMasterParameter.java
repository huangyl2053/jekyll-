/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainjikan;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール登録6を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosainJikanMasterParameter {

    private final FlexibleDate ninteiChosaYoteiYMD;
    private final Code chosaChikuCode;
    private final RString ninteiChosaItakusakiCode;
    private final RString ninteiChosainCode;
    private final LasdecCode shichosonCode;
    private final RString ninteiChosaYoteiKaishiTime;
    private final RString ninteiChosaYoteiShuryoTime;
    private final Code ninteiChosaJikanWaku;

    private NinteiChosainJikanMasterParameter(
            FlexibleDate ninteiChosaYoteiYMD,
            Code chosaChikuCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            LasdecCode shichosonCode,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku) {
        this.ninteiChosaYoteiYMD = ninteiChosaYoteiYMD;
        this.chosaChikuCode = chosaChikuCode;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosainCode = ninteiChosainCode;
        this.shichosonCode = shichosonCode;
        this.ninteiChosaYoteiKaishiTime = ninteiChosaYoteiKaishiTime;
        this.ninteiChosaYoteiShuryoTime = ninteiChosaYoteiShuryoTime;
        this.ninteiChosaJikanWaku = ninteiChosaJikanWaku;
    }

    /**
     * 認定調査スケジュール登録6のパラメータを生成します。
     *
     * @param ninteiChosaYoteiYMD 認定調査予定年月日
     * @param chosaChikuCode 調査地区コード
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param shichosonCode 市町村コード
     * @return 認定調査スケジュール登録6パラメータ
     */
    public static NinteiChosainJikanMasterParameter createParam時間枠設定一覧情報(
            FlexibleDate ninteiChosaYoteiYMD,
            Code chosaChikuCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            LasdecCode shichosonCode) {
        return new NinteiChosainJikanMasterParameter(
                ninteiChosaYoteiYMD,
                chosaChikuCode,
                ninteiChosaItakusakiCode,
                ninteiChosainCode,
                shichosonCode,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY);
    }

    /**
     * 認定調査スケジュール登録6のパラメータを生成します。
     *
     * @param ninteiChosaYoteiYMD 認定調査予定年月日
     * @param chosaChikuCode 調査地区コード
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param shichosonCode 市町村コード
     * @param ninteiChosaYoteiKaishiTime 認定調査予定開始時間
     * @param ninteiChosaYoteiShuryoTime 認定調査予定終了時間
     * @param ninteiChosaJikanWaku 認定調査時間枠
     * @return 認定調査スケジュール登録6パラメータ
     */
    public static NinteiChosainJikanMasterParameter createParam時間枠設定(
            FlexibleDate ninteiChosaYoteiYMD,
            Code chosaChikuCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            LasdecCode shichosonCode,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku) {
        return new NinteiChosainJikanMasterParameter(
                ninteiChosaYoteiYMD,
                chosaChikuCode,
                ninteiChosaItakusakiCode,
                ninteiChosainCode,
                shichosonCode,
                ninteiChosaYoteiKaishiTime,
                ninteiChosaYoteiShuryoTime,
                ninteiChosaJikanWaku);
    }
}
