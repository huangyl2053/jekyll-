/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc010010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc010010.JuryoininKeiyakuShoninKakuninshoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護保険受領委任契約承認（不承認）確認書のProcessParameter
 *
 * @reamsid_L DBC-1910-030 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JuryoininKeiyakuShoninKakuninshoProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 契約申請日開始;
    private FlexibleDate 契約申請日終了;
    private FlexibleDate 契約決定日開始;
    private FlexibleDate 契約決定日終了;
    private RString 発行済;
    private FlexibleDate 通知日;
    private RString 文書番号;
    private RString 改頁出力順;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RDateTime 処理日時;

    private RString 利用者向けタイトル;
    private RString 利用者向け通知文1;
    private RString 利用者向け通知文2;
    private RString 事業者用タイトル;
    private RString 事業者用通知文1;
    private RString 事業者用通知文2;

    /**
     * コンストラクタです.
     *
     * @param 契約申請日開始 契約申請日開始
     * @param 契約申請日終了 契約申請日終了
     * @param 契約決定日開始 契約決定日開始
     * @param 契約決定日終了 契約決定日終了
     * @param 発行済 発行済
     * @param 通知日 通知日
     * @param 文書番号 文書番号
     * @param 改頁出力順 改頁出力順
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 処理日時 処理日時
     */
    public JuryoininKeiyakuShoninKakuninshoProcessParameter(FlexibleDate 契約申請日開始, FlexibleDate 契約申請日終了, FlexibleDate 契約決定日開始,
            FlexibleDate 契約決定日終了, RString 発行済, FlexibleDate 通知日, RString 文書番号, RString 改頁出力順, LasdecCode 市町村コード,
            RString 市町村名称, RDateTime 処理日時) {
        this.契約申請日開始 = 契約申請日開始;
        this.契約申請日終了 = 契約申請日終了;
        this.契約決定日開始 = 契約決定日開始;
        this.契約決定日終了 = 契約決定日終了;
        this.発行済 = 発行済;
        this.通知日 = 通知日;
        this.文書番号 = 文書番号;
        this.改頁出力順 = 改頁出力順;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.処理日時 = 処理日時;
    }

    /**
     * 介護保険受領委任契約承認（不承認）確認書のMybatisParameterを作成する。
     *
     * @return JuryoininKeiyakuShoninKakuninshoMybatisParameter
     */
    public JuryoininKeiyakuShoninKakuninshoMybatisParameter toJuryoininKeiyakuShoninKakuninshoMybatisParameter() {
        return new JuryoininKeiyakuShoninKakuninshoMybatisParameter(契約申請日開始, 契約申請日終了,
                契約決定日開始, 契約決定日終了, 発行済, 改頁出力順, 処理日時.getDate());

    }

}
