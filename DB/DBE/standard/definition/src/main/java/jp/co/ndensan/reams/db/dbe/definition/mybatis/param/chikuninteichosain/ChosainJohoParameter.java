/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール登録2用パラメータクラスです。
 */
@lombok.Getter
public class ChosainJohoParameter {

    private final FlexibleDate Temp_設定日;
    private final boolean Temp_調査員状況02;
    private final Code chosaChikuCode;
    private final LasdecCode shichosonCode;
    private final RString ninteiChosaItakusakiCode;
    private final RString ninteiChosainCode;
    private final FlexibleDate ninteiChosaYoteiYMD;
    private final RString ninteiChosaYoteiKaishiTime;
    private final RString ninteiChosaYoteiShuryoTime;
    private final Code ninteiChosaJikanWaku;

    private ChosainJohoParameter(
            FlexibleDate Temp_設定日,
            boolean Temp_調査員状況02,
            Code chosaChikuCode,
            LasdecCode shichosonCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            FlexibleDate ninteiChosaYoteiYMD,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku) {
        this.Temp_設定日 = requireNonNull(Temp_設定日, UrSystemErrorMessages.値がnull.getReplacedMessage("Temp_設定日"));
        this.Temp_調査員状況02 = Temp_調査員状況02;
        this.chosaChikuCode = requireNonNull(chosaChikuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("対象地区コード"));
        this.shichosonCode = requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        this.ninteiChosaItakusakiCode = requireNonNull(ninteiChosaItakusakiCode, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        this.ninteiChosainCode = requireNonNull(ninteiChosainCode, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
        this.ninteiChosaYoteiYMD = requireNonNull(ninteiChosaYoteiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定日"));
        this.ninteiChosaYoteiKaishiTime = requireNonNull(ninteiChosaYoteiKaishiTime, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定開始時間"));
        this.ninteiChosaYoteiShuryoTime = requireNonNull(ninteiChosaYoteiShuryoTime, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定終了時間"));
        this.ninteiChosaJikanWaku = requireNonNull(ninteiChosaJikanWaku, UrSystemErrorMessages.値がnull.getReplacedMessage("選択された時間枠"));
    }

//メモ情報件数を取得する
    public static ChosainJohoParameter createParam_メモ情報件数(FlexibleDate Temp_設定日, Code chosaChikuCode) {
        return new ChosainJohoParameter(
                FlexibleDate.MAX,
                true,
                chosaChikuCode,
                LasdecCode.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                FlexibleDate.MAX,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    //認定調査スケジュール詳細情報を取得する
    public static ChosainJohoParameter createParam_認定調査スケジュール詳細情報(
            FlexibleDate Temp_設定日,
            boolean Temp_調査員状況02,
            Code chosaChikuCode,
            LasdecCode shichosonCode,
            RString ninteiChosaItakusakiCode) {
        return new ChosainJohoParameter(
                Temp_設定日,
                Temp_調査員状況02,
                chosaChikuCode,
                shichosonCode,
                ninteiChosaItakusakiCode,
                RString.EMPTY,
                FlexibleDate.MAX,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    //「対象地区」DDLのonselectイベント
    public static ChosainJohoParameter createParam_保険者名(
            Code chosaChikuCode) {
        return new ChosainJohoParameter(
                FlexibleDate.MAX,
                true,
                chosaChikuCode,
                LasdecCode.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                FlexibleDate.MAX,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    //「保険者」DDLのonselectイベント
    public static ChosainJohoParameter createParam_認定調査委託先名称(
            Code chosaChikuCode,
            LasdecCode shichosonCode) {
        return new ChosainJohoParameter(
                FlexibleDate.MAX,
                true,
                chosaChikuCode,
                LasdecCode.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                FlexibleDate.MAX,
                RString.EMPTY,
                RString.EMPTY,
                Code.EMPTY
        );
    }

    //「検索する」ボタンのonclickイベント
    public static ChosainJohoParameter createParam_申請書管理番号(
            Code chosaChikuCode,
            LasdecCode shichosonCode,
            RString ninteiChosaItakusakiCode,
            RString ninteiChosainCode,
            FlexibleDate ninteiChosaYoteiYMD,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku) {
        return new ChosainJohoParameter(
                FlexibleDate.MAX,
                true,
                chosaChikuCode,
                shichosonCode,
                ninteiChosaItakusakiCode,
                ninteiChosainCode,
                ninteiChosaYoteiYMD,
                ninteiChosaYoteiKaishiTime,
                ninteiChosaYoteiShuryoTime,
                ninteiChosaJikanWaku
        );
    }
}
