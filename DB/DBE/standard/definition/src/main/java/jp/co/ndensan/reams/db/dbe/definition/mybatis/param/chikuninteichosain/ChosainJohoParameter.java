/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール登録2用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChosainJohoParameter {

    private final FlexibleDate 設定日;
    private final RString 調査員状況;
    private final boolean is空き;
    private final Code chosaChikuCode;
    private final LasdecCode shichosonCode;
    private final boolean is保険者;
    private final RString ninteiChosaItakusakiCode;
    private final RString ninteiChosainCode;
    private final RString ninteiChosaYoteiKaishiTime;
    private final RString ninteiChosaYoteiShuryoTime;
    private final Code ninteiChosaJikanWaku;

    /**
     *
     * @param 設定日
     * @param 調査員状況
     * @param is空き
     * @param chosaChikuCode 対象地区コード
     * @param shichosonCode 市町村コード
     * @param is保険者 is保険者
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param ninteiChosaYoteiKaishiTime 認定調査予定開始時間
     * @param ninteiChosaYoteiShuryoTime 認定調査予定終了時間
     * @param ninteiChosaJikanWaku
     */
    private ChosainJohoParameter(
            FlexibleDate 設定日,
            RString 調査員状況,
            boolean is空き,
            Code chosaChikuCode,
            LasdecCode shichosonCode,
            boolean is保険者,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku) {
        this.設定日 = 設定日;
        this.調査員状況 = 調査員状況;
        this.is空き = is空き;
        this.chosaChikuCode = chosaChikuCode;
        this.shichosonCode = shichosonCode;
        this.is保険者 = is保険者;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosainCode = ninteiChosainCode;
        this.ninteiChosaYoteiKaishiTime = ninteiChosaYoteiKaishiTime;
        this.ninteiChosaYoteiShuryoTime = ninteiChosaYoteiShuryoTime;
        this.ninteiChosaJikanWaku = ninteiChosaJikanWaku;
    }

    /**
     *
     * @param 設定日 設定日
     * @param chosaChikuCode 対象地区コード
     * @return 認定調査スケジュール登録2用パラメータ
     */
    public static ChosainJohoParameter createParam_メモ情報件数(FlexibleDate 設定日, Code chosaChikuCode) {
        return new ChosainJohoParameter(
                設定日,
                RString.EMPTY,
                true,
                chosaChikuCode,
                LasdecCode.EMPTY,
                true,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    /**
     *
     * @param 設定日 設定日
     * @param 調査員状況02 調査員状況02
     * @param chosaChikuCode 対象地区コード
     * @param shichosonCode 市町村コード
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @return 認定調査スケジュール登録2用パラメータ
     */
    public static ChosainJohoParameter createParam_認定調査スケジュール詳細情報(
            FlexibleDate 設定日,
            RString 調査員状況02,
            Code chosaChikuCode,
            LasdecCode shichosonCode,
            RString ninteiChosaItakusakiCode) {
        boolean is空き = false;
        if (調査員状況02.equals(new RString("空き"))) {
            is空き = true;
        }
        return new ChosainJohoParameter(
                設定日,
                調査員状況02,
                is空き,
                chosaChikuCode,
                shichosonCode,
                true,
                ninteiChosaItakusakiCode,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    /**
     *
     * @param chosaChikuCode 対象地区コード
     * @return 認定調査スケジュール登録2用パラメータ
     */
    public static ChosainJohoParameter createParam_保険者名(
            Code chosaChikuCode) {
        return new ChosainJohoParameter(
                FlexibleDate.MAX,
                RString.EMPTY,
                true,
                chosaChikuCode,
                LasdecCode.EMPTY,
                true,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    /**
     *
     * @param chosaChikuCode 対象地区コード
     * @param shichosonCode 市町村コード
     * @return 認定調査スケジュール登録2用パラメータ
     */
    public static ChosainJohoParameter createParam_認定調査委託先名称(
            Code chosaChikuCode,
            LasdecCode shichosonCode) {
        return new ChosainJohoParameter(
                FlexibleDate.MAX,
                RString.EMPTY,
                true,
                chosaChikuCode,
                shichosonCode,
                true,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    /**
     *
     * @param 設定日 設定日
     * @param chosaChikuCode 対象地区コード
     * @param shichosonCode 市町村コード
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     * @param ninteiChosainCode 認定調査員コード
     * @param ninteiChosaYoteiKaishiTime 認定調査予定開始時間
     * @param ninteiChosaYoteiShuryoTime 認定調査予定終了時間
     * @param ninteiChosaJikanWaku 選択された時間枠
     * @return 認定調査スケジュール登録2用パラメータ
     */
    public static ChosainJohoParameter createParam_申請書管理番号(
            FlexibleDate 設定日,
            Code chosaChikuCode,
            LasdecCode shichosonCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku) {
        return new ChosainJohoParameter(
                設定日,
                RString.EMPTY,
                true,
                chosaChikuCode,
                shichosonCode,
                true,
                ninteiChosaItakusakiCode,
                ninteiChosainCode,
                ninteiChosaYoteiKaishiTime,
                ninteiChosaYoteiShuryoTime,
                ninteiChosaJikanWaku
        );
    }

    /**
     *
     * @param shichosonCode 市町村コード
     * @return 認定調査スケジュール登録2用パラメータ
     */
    public static ChosainJohoParameter createParam_調査地区コード取得(
            LasdecCode shichosonCode) {
        boolean is保険者 = false;
        if (shichosonCode != null && !shichosonCode.isEmpty()) {
            is保険者 = true;
        }
        return new ChosainJohoParameter(
                FlexibleDate.EMPTY,
                RString.EMPTY,
                true,
                Code.EMPTY,
                shichosonCode,
                is保険者,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }
}
