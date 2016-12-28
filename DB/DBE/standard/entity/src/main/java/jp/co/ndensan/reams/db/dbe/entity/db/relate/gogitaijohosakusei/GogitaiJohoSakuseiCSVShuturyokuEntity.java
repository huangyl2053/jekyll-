/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
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
    @CsvField(order = 7, name = "開催場所")
    private RString shinsakaiKaisaiBasho;
    @CsvField(order = 8, name = "精神科医所属")
    private RString gogitaiSeishinkaSonzaiFlag;
    @CsvField(order = 9, name = "合議体研修")
    private RString gogitaiDummyFlag;

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
