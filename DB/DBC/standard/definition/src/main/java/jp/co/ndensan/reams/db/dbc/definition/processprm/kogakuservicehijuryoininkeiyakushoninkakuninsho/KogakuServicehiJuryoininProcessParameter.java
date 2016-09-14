/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehijuryoininkeiyakushoninkakuninsho;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc010020.KogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のバッチプロセス用パラメータクラスです。
 *
 * @reamsid_L DBC-1970-030 zhouchuanlin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiJuryoininProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 契約申請開始;
    private FlexibleDate 契約申請終了;
    private FlexibleDate 契約決定開始;
    private FlexibleDate 契約決定終了;
    private RString 発行済;
    private FlexibleDate 通知日;
    private RString 文書番号;
    private RString 改頁出力順ID;
    private LasdecCode 市町村コード;
    private RDateTime 処理日時;
    private RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 契約申請開始 RDate
     * @param 契約申請終了 RDate
     * @param 契約決定開始 RDate
     * @param 契約決定終了 RDate
     * @param 発行済 RString
     * @param 通知日 RDate
     * @param 文書番号 RString
     * @param 改頁出力順ID RString
     * @param 市町村コード LasdecCode
     * @param 処理日時 RDate
     */
    public KogakuServicehiJuryoininProcessParameter(FlexibleDate 契約申請開始, FlexibleDate 契約申請終了, FlexibleDate 契約決定開始,
            FlexibleDate 契約決定終了, RString 発行済, FlexibleDate 通知日, RString 文書番号, RString 改頁出力順ID, LasdecCode 市町村コード, RDateTime 処理日時) {
        this.契約申請開始 = 契約申請開始;
        this.契約申請終了 = 契約申請終了;
        this.契約決定開始 = 契約決定開始;
        this.契約決定終了 = 契約決定終了;
        this.発行済 = 発行済;
        this.通知日 = 通知日;
        this.文書番号 = 文書番号;
        this.改頁出力順ID = 改頁出力順ID;
        this.市町村コード = 市町村コード;
        this.処理日時 = 処理日時;
    }

    /**
     * Mybatisパラメータを作成します。
     *
     * @return KogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter Mybatisパラメータ
     */
    public KogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter toKogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter() {
        return new KogakuServicehiJuryoininKeiyakuShoninKakuninshoMybatisParameter(契約申請開始, 契約申請終了, 契約決定開始,
                契約決定終了, 発行済, 出力順, 処理日時.getDate());
    }
}
