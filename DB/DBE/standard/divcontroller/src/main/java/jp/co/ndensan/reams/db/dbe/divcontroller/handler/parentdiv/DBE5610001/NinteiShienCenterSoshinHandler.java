/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE561001.DBE561001_CenterTransmissionParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.NinteiShienCenterSoshinDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信準備のHandlerクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
public class NinteiShienCenterSoshinHandler {

    private static final RString 未出力 = new RString("key0");
    private final NinteiShienCenterSoshinDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShienCenterSoshinDiv
     */
    public NinteiShienCenterSoshinHandler(NinteiShienCenterSoshinDiv div) {
        this.div = div;
    }

    /**
     * 初期化の項目設定処理です。
     */
    public void onLoad() {
        div.getRadDataShutsuryoku().setSelectedKey(new RString("key0"));
        RDate システム日付 = RDate.getNowDate();
        div.getTxtNijiHanteibi().clearFromValue();
        div.getTxtNijiHanteibi().setToValue(システム日付);
    }

    /**
     * センター送信データ作成のバッチパラメータ設定です。
     *
     * @return DBE561001_CenterTransmissionParameter
     */
    public DBE561001_CenterTransmissionParameter setParameter() {
        RDate 二次判定日_開始 = div.getTxtNijiHanteibi().getFromValue();
        RDate 二次判定日_終了 = div.getTxtNijiHanteibi().getToValue();
        RString 転入_死亡情報出力区分 = div.getRadTennyuShiboJoho().getSelectedKey();
        RString データ出力区分 = div.getRadDataShutsuryoku().getSelectedKey();
        DBE561001_CenterTransmissionParameter parameter = new DBE561001_CenterTransmissionParameter();
        parameter.set二次判定開始日(二次判定日_開始 != null ? 二次判定日_開始.toDateString() : RString.EMPTY);
        parameter.set二次判定終了日(二次判定日_終了 != null ? 二次判定日_終了.toDateString() : RString.EMPTY);
        if (未出力.equals(データ出力区分)) {
            parameter.setデータ出力区分(new RString("0"));
        } else {
            parameter.setデータ出力区分(new RString("1"));
        }
        if (未出力.equals(転入_死亡情報出力区分)) {
            parameter.set転入死亡情報出力区分(new RString("0"));
        } else {
            parameter.set転入死亡情報出力区分(new RString("1"));
        }
        return parameter;
    }
}
