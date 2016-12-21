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
public class GogitaiJohoSakuseiCSVEntity {

    @CsvField(order = 1)
    private RString gogitaiNo;
    @CsvField(order = 2)
    private RString gogitaiMei;
    @CsvField(order = 3)
    private RString gogitaiYukoKikanKaishiYMD;
    @CsvField(order = 4)
    private RString gogitaiYukoKikanShuryoYMD;
    @CsvField(order = 5)
    private RString gogitaiKaishiYoteiTime;
    @CsvField(order = 6)
    private RString gogitaiShuryoYoteiTime;
    @CsvField(order = 7)
    private RString shinsakaiYoteiTeiin;
    @CsvField(order = 8)
    private RString shinsakaiJidoWariateTeiin;
    @CsvField(order = 9)
    private RString shinsakaiIinTeiin;
    @CsvField(order = 10)
    private RString shinsakaiKaisaiBashoCode;
    @CsvField(order = 11)
    private RString gogitaiSeishinkaSonzaiFlag;
    @CsvField(order = 12)
    private RString gogitaiDummyFlag;
    @CsvField(order = 13)
    private RString shinsakaiIinCode;
    @CsvField(order = 14)
    private RString substituteFlag;
    @CsvField(order = 15)
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
        entity.setShinsakaiKaisaiBashoCode(this.shinsakaiKaisaiBashoCode);
        entity.setShinsakaiYoteiTeiin(strToInt(this.shinsakaiYoteiTeiin));
        entity.setShinsakaiJidoWariateTeiin(strToInt(this.shinsakaiJidoWariateTeiin));
        entity.setShinsakaiIinTeiin(strToInt(this.shinsakaiIinTeiin));
        entity.setGogitaiSeishinkaSonzaiFlag(strToBoolean(this.gogitaiSeishinkaSonzaiFlag));
        entity.setGogitaiDummyFlag(strToBoolean(this.gogitaiDummyFlag));

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
        entity.setShinsakaiIinCode(this.shinsakaiIinCode);
        entity.setGogitaichoKubunCode(new Code(this.gogitaichoKubunCode));
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
