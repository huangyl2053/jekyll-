/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shotokujohoichiranhyosakusei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域市町村の所得情報一覧取得のパラメタです。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoIchiranhyoSakuseiGParameter implements IMyBatisParameter {

    private FlexibleYear 処理年度;
    private RString チックボックス;
    private RString ラジオボタン;
    private YMDHMS 開始日時;
    private YMDHMS 終了日時;
    private List<LasdecCode> 市町村コードリスト;
    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 FlexibleYear
     * @param チックボックス RString
     * @param ラジオボタン RString
     * @param 開始日時 YMDHMS
     * @param 終了日時 YMDHMS
     * @param 市町村コードリスト List<LasdecCode>
     * @param 出力順 RString
     */
    public ShotokuJohoIchiranhyoSakuseiGParameter(FlexibleYear 処理年度,
            RString チックボックス,
            RString ラジオボタン,
            YMDHMS 開始日時,
            YMDHMS 終了日時,
            List<LasdecCode> 市町村コードリスト,
            RString 出力順) {
        this.処理年度 = 処理年度;
        this.チックボックス = チックボックス;
        this.ラジオボタン = ラジオボタン;
        this.開始日時 = 開始日時;
        this.終了日時 = 終了日時;
        this.市町村コードリスト = 市町村コードリスト;
        this.出力順 = 出力順;
    }

    /**
     * toShotokuJohoIchiranhyoSakuseiGParameterを作成します。
     *
     * @param 処理年度 FlexibleYear
     * @param チックボックス RString
     * @param ラジオボタン RString
     * @param 開始日時 YMDHMS
     * @param 終了日時 YMDHMS
     * @param 市町村コードリスト List<LasdecCode>
     * @param 出力順 RString
     * @return ShotokuJohoIchiranhyoSakuseiGParameter
     */
    public ShotokuJohoIchiranhyoSakuseiGParameter toShotokuJohoIchiranhyoSakuseiGParameter(FlexibleYear 処理年度,
            RString チックボックス,
            RString ラジオボタン,
            YMDHMS 開始日時,
            YMDHMS 終了日時,
            List<LasdecCode> 市町村コードリスト,
            RString 出力順) {
        return new ShotokuJohoIchiranhyoSakuseiGParameter(処理年度,
                チックボックス, ラジオボタン, 開始日時, 終了日時, 市町村コードリスト, 出力順);
    }
}
