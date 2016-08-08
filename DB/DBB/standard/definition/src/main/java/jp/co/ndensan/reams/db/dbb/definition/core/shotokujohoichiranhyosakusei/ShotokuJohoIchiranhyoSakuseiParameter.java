/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyosakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ51003_1_所得情報一覧表作成（バッチ）のMapper
 *
 * @reamsid_L DBB-1650-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoIchiranhyoSakuseiParameter implements IMyBatisParameter {

    private FlexibleYear 処理年度;
    private RString チックボックス;
    private RString ラジオボタン;
    private LasdecCode 市町村コード;
    private YMDHMS 開始日時;
    private YMDHMS 終了日時;
    private RString 出力順;
    private int システム年;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 FlexibleYear
     * @param チックボックス RString
     * @param ラジオボタン RString
     * @param 市町村コード LasdecCode
     * @param 開始日時 YMDHMS
     * @param 終了日時 YMDHMS
     * @param 出力順 RString
     * @param システム年 int
     */
    public ShotokuJohoIchiranhyoSakuseiParameter(FlexibleYear 処理年度,
            RString チックボックス,
            RString ラジオボタン,
            LasdecCode 市町村コード,
            YMDHMS 開始日時,
            YMDHMS 終了日時,
            RString 出力順,
            int システム年) {
        this.処理年度 = 処理年度;
        this.チックボックス = チックボックス;
        this.ラジオボタン = ラジオボタン;
        this.市町村コード = 市町村コード;
        this.開始日時 = 開始日時;
        this.終了日時 = 終了日時;
        this.出力順 = 出力順;
        this.システム年 = システム年;
    }

    /**
     * toShotokuJohoIchiranhyoSakuseiParameter。
     *
     * @param 処理年度 FlexibleYear
     * @param チックボックス RString
     * @param ラジオボタン RString
     * @param 市町村コード LasdecCode
     * @param 開始日時 YMDHMS
     * @param 終了日時 YMDHMS
     * @param 出力順 RString
     * @param システム年 int
     * @return ShotokuJohoIchiranhyoSakuseiParameter
     */
    public ShotokuJohoIchiranhyoSakuseiParameter toShotokuJohoIchiranhyoSakuseiParameter(FlexibleYear 処理年度,
            RString チックボックス,
            RString ラジオボタン,
            LasdecCode 市町村コード,
            YMDHMS 開始日時,
            YMDHMS 終了日時,
            RString 出力順,
            int システム年) {
        return new ShotokuJohoIchiranhyoSakuseiParameter(処理年度, チックボックス, ラジオボタン, 市町村コード,
                開始日時, 終了日時, 出力順, システム年);
    }
}
