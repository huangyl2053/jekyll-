/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.ninteichosaschedule;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class NinteichosaScheduleMapperParameter {

    private final FlexibleDate 認定調査予定年月日;
    private final RString 認定調査予定開始時間;
    private final RString 認定調査予定終了時間;
    private final Code 認定調査時間枠;
    private final Code 調査地区コード;
    private final RString 認定調査委託先コード;
    private final RString 認定調査員コード;
    private final LasdecCode 市町村コード;
    private final boolean uses認定調査予定年月日;
    private final boolean uses認定調査予定開始時間;
    private final boolean uses認定調査予定終了時間;
    private final boolean uses認定調査時間枠;
    private final boolean uses調査地区コード;
    private final boolean uses認定調査委託先コード;
    private final boolean uses認定調査員コード;
    private final boolean uses市町村コード;

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @param 認定調査予定開始時間 認定調査予定開始時間
     * @param 認定調査予定終了時間 認定調査予定終了時間
     * @param 認定調査時間枠 認定調査時間枠
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @return 認定調査スケジュール情報検索パラメータ
     */
    public static NinteichosaScheduleMapperParameter createSelectByKeyParam(
            FlexibleDate 認定調査予定年月日,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            Code 認定調査時間枠,
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        return new NinteichosaScheduleMapperParameter(認定調査予定年月日,
                認定調査予定開始時間,
                認定調査予定終了時間,
                認定調査時間枠,
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード, true, true, true, true, true, true, true, true);
    }

    private NinteichosaScheduleMapperParameter(FlexibleDate 認定調査予定年月日,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            Code 認定調査時間枠,
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード,
            boolean uses認定調査予定年月日,
            boolean uses認定調査予定開始時間,
            boolean uses認定調査予定終了時間,
            boolean uses認定調査時間枠,
            boolean uses調査地区コード,
            boolean uses認定調査委託先コード,
            boolean uses認定調査員コード,
            boolean uses市町村コード) {
        this.認定調査予定年月日 = 認定調査予定年月日;
        this.認定調査予定開始時間 = 認定調査予定開始時間;
        this.認定調査予定終了時間 = 認定調査予定終了時間;
        this.認定調査時間枠 = 認定調査時間枠;
        this.調査地区コード = 調査地区コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.市町村コード = 市町村コード;
        this.uses認定調査予定年月日 = uses認定調査予定年月日;
        this.uses認定調査予定開始時間 = uses認定調査予定開始時間;
        this.uses認定調査予定終了時間 = uses認定調査予定終了時間;
        this.uses認定調査時間枠 = uses認定調査時間枠;
        this.uses調査地区コード = uses調査地区コード;
        this.uses認定調査委託先コード = uses認定調査委託先コード;
        this.uses認定調査員コード = uses認定調査員コード;
        this.uses市町村コード = uses市町村コード;
    }
}
