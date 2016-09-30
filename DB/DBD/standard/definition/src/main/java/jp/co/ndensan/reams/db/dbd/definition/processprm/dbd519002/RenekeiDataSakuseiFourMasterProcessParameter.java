/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519002;

import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.Datakubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519002.RenekeiDataSakuseiMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定関連データのパラメータクラスです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RenekeiDataSakuseiFourMasterProcessParameter implements IBatchProcessParameter {

    private RString shikibetsucode;
    private RDateTime konkaishoriymdtime_from;
    private RDateTime konkaishoriymdtime_to;
    private RString csvfilename;
    private boolean isReams;

    /**
     * コンストラクタです
     *
     * @param shikibetsucode 識別コード
     * @param konkaishoriymdtime_from 今回処理日時開始日時
     * @param konkaishoriymdtime_to 今回処理日時終了日時
     * @param csvfilename CSVファイル名
     * @param isReams 電算版区分
     */
    public RenekeiDataSakuseiFourMasterProcessParameter(
            RString shikibetsucode,
            RDateTime konkaishoriymdtime_from,
            RDateTime konkaishoriymdtime_to,
            RString csvfilename,
            boolean isReams) {
        this.shikibetsucode = shikibetsucode;
        this.konkaishoriymdtime_from = konkaishoriymdtime_from;
        this.konkaishoriymdtime_to = konkaishoriymdtime_to;
        this.csvfilename = csvfilename;
        this.isReams = isReams;
    }

    /**
     * コンストラクタです。
     *
     * @param konkaishoriymdtime_from 今回処理日時開始日時
     * @param konkaishoriymdtime_to 今回処理日時終了日時
     */
    public RenekeiDataSakuseiFourMasterProcessParameter(
            RDateTime konkaishoriymdtime_from,
            RDateTime konkaishoriymdtime_to) {
        this.konkaishoriymdtime_from = konkaishoriymdtime_from;
        this.konkaishoriymdtime_to = konkaishoriymdtime_to;
    }

    /**
     * バッチMybatisパラメターを取得します。
     *
     * @return バッチMybatis
     */
    public RenekeiDataSakuseiMyBatisParameter toRenekeiDataSakuseiMyBatisParameter() {
        return new RenekeiDataSakuseiMyBatisParameter(konkaishoriymdtime_from, konkaishoriymdtime_to);
    }

    /**
     * 介護認定外部データ出力履歴に更新Mybatisパラメターを取得します。
     *
     * @return Mybatisパラメター
     */
    public RenekeiDataSakuseiMyBatisParameter toYokaigoNinteiGaibuDataMyBatisParameter() {
        return new RenekeiDataSakuseiMyBatisParameter(new Code(Datakubun.マスタ4.getコード()));
    }
}
