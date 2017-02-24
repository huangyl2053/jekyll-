/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報作成RelateEntityクラスです。
 *
 * @reamsid_L DBE-0090-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoSakuseiCSVShuturyokuEntity {

    @CsvField(order = 1, name = "合議体番号")
    private RString gogitaiNo;
    @CsvField(order = 2, name = "合議体名称")
    private RString gogitaiMei;
    @CsvField(order = 3, name = "有効開始日")
    private RString gogitaiYukoKikanKaishiYMD;
    @CsvField(order = 4, name = "有効終了日")
    private RString gogitaiYukoKikanShuryoYMD;
    @CsvField(order = 5, name = "開始予定時刻")
    private RString gogitaiKaishiYoteiTime;
    @CsvField(order = 6, name = "終了予定時刻")
    private RString gogitaiShuryoYoteiTime;
    @CsvField(order = 7, name = "審査会予定定員")
    private RString shinsakaiYoteiTeiin;
    @CsvField(order = 8, name = "審査会自動割当定員")
    private RString shinsakaiJidoWariateTeiin;
    @CsvField(order = 9, name = "審査会委員定員")
    private RString shinsakaiIinTeiin;
    @CsvField(order = 10, name = "開催場所")
    private RString shinsakaiKaisaiBasho;
    @CsvField(order = 11, name = "精神科医所属")
    private RString gogitaiSeishinkaSonzaiFlag;
    @CsvField(order = 12, name = "研修（模擬）")
    private RString gogitaiDummyFlag;
    @CsvField(order = 13, name = "審査会委員コード")
    private RString shinsakaiIinCode;
    @CsvField(order = 14, name = "補欠")
    private RString substituteFlag;
    @CsvField(order = 15, name = "合議体長区分コード")
    private RString gogitaichoKubunCode;

    /**
     * CSVデータから、合議体情報テーブルを設定します。
     *
     * @return DbT5591GogitaiJohoEntity
     */
    public DbT5591GogitaiJohoEntity toDbt5591Entity() {
        DbT5591GogitaiJohoEntity entity = new DbT5591GogitaiJohoEntity();
        entity.setGogitaiNo(strToInt(this.gogitaiNo));
        entity.setGogitaiYukoKikanKaishiYMD(strToFlex(this.gogitaiYukoKikanKaishiYMD));
        entity.setGogitaiYukoKikanShuryoYMD(strToFlex(this.gogitaiYukoKikanShuryoYMD));
        entity.setGogitaiMei(this.gogitaiMei);
        entity.setGogitaiKaishiYoteiTime(this.gogitaiKaishiYoteiTime);
        entity.setGogitaiShuryoYoteiTime(this.gogitaiShuryoYoteiTime);
        entity.setShinsakaiKaisaiBashoCode(this.shinsakaiKaisaiBasho);
        entity.setGogitaiSeishinkaSonzaiFlag(strToBoolean(this.gogitaiSeishinkaSonzaiFlag));
        entity.setGogitaiDummyFlag(strToBoolean(this.gogitaiDummyFlag));
        entity.setShinsakaiJidoWariateTeiin(strToInt(this.shinsakaiJidoWariateTeiin));
        entity.setShinsakaiIinTeiin(strToInt(this.shinsakaiIinTeiin));
        entity.setShinsakaiYoteiTeiin(strToInt(this.shinsakaiYoteiTeiin));
        return entity;
    }

    /**
     * CSVデータから、合議体割当委員情報テーブルを設定します。
     *
     * @return DbT5593GogitaiWariateIinJohoEntity
     */
    public DbT5593GogitaiWariateIinJohoEntity toDbt5593Entity() {
        DbT5593GogitaiWariateIinJohoEntity entity = new DbT5593GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(strToInt(this.gogitaiNo));
        entity.setGogitaiYukoKikanKaishiYMD(strToFlex(this.gogitaiYukoKikanKaishiYMD));
        entity.setGogitaiYukoKikanShuryoYMD(strToFlex(this.gogitaiYukoKikanShuryoYMD));
        entity.setGogitaichoKubunCode(new Code(this.gogitaichoKubunCode));
        entity.setShinsakaiIinCode(this.shinsakaiIinCode);
        entity.setSubstituteFlag(strToBoolean(this.substituteFlag));
        return entity;
    }

    private int strToInt(RString str) {
        return Integer.parseInt(str.toString());
    }

    private boolean strToBoolean(RString str) {
        return new RString("0").equals(str);
    }

    private FlexibleDate strToFlex(RString str) {
        return new FlexibleDate(str.replace(new RString("/"), RString.EMPTY));
    }
}
