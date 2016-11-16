/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShotokuNendoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.KouhoshaTenyuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiKouhoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会候補者Tempテーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsJuminJohoTmpProcess extends BatchProcessBase<KouhoshaTenyuEntity> {

    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_18 = 18;
    private static final int INT_31 = 31;
    private static final int INT_39 = 39;
    private static final int 一月 = 1;
    private static final int 三月 = 3;
    private static final int 四月 = 4;
    private static final int 七月 = 7;
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select候補者転入者");
    private static final RString 所得照会候補者TEMP = new RString("ShotokuShoukaiKouhoshaTemp");
    private ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 所得照会候補者writer;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private ShotokuNendoParameter myBatisParameter;

    @Override
    protected void createWriter() {
        所得照会候補者writer = new BatchEntityCreatedTempTableWriter(所得照会候補者TEMP, ShotokuShoukaiKouhoshaTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = creatParameter();
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void process(KouhoshaTenyuEntity t) {

        if (識別コード.equals(t.get識別コード())) {
            識別コード = t.get識別コード();
        } else {
            所得照会候補者writer.insert(creatEntity(t));
            識別コード = t.get識別コード();
        }
    }

    private ShotokuShoukaiKouhoshaTempEntity creatEntity(KouhoshaTenyuEntity t) {
        ShotokuShoukaiKouhoshaTempEntity tempEntity = new ShotokuShoukaiKouhoshaTempEntity();
        tempEntity.setKouhoshakubun(t.get候補者区分());
        tempEntity.setShikibetsuCode(t.get識別コード());
        tempEntity.setJuminShubetsuCode(t.get住民種別コード());
        tempEntity.setAtenaShimei(t.get名称());
        tempEntity.setAtenaKanaShimei(t.getカナ名称());
        tempEntity.setKannaiKangaiKubun(t.get管内管外区分());
        tempEntity.setYubinNo(t.get郵便番号());
        tempEntity.setChoikiCode(t.get町域コード());
        tempEntity.setZenkokuJushoCode(t.get全国住所コード());
        tempEntity.setTenshutsuKakuteiZenkokuJushoCode(t.get転出確定全国住所コード());
        tempEntity.setJusho(t.get住所());
        tempEntity.setBanchi(t.get番地());
        tempEntity.setKatagaki(t.get方書());
        tempEntity.setGyoseikuCode(t.get行政区コード());
        tempEntity.setChikuCode1(t.get地区コード１());
        tempEntity.setChikuCode2(t.get地区コード２());
        tempEntity.setChikuCode3(t.get地区コード３());
        tempEntity.setJuminJotaiCode(t.get住民状態コード());
        tempEntity.setSetaiCode(t.get世帯コード());
        tempEntity.setSeinengappiYMD(t.get生年月日());
        tempEntity.setTorokuIdoYMD(t.get登録異動年月日());
        tempEntity.setTorokuTodokedeYMD(t.get登録届出年月日());
        tempEntity.setSeibetsuCode(t.get性別コード());
        tempEntity.setTenyuzenzenkokuJushoCode(t.get転入前全国住所コード());
        tempEntity.setTenyuzenjusho(t.get転入前住所());
        tempEntity.setTenyuzenbanchi(t.get転入前番地());
        tempEntity.setTenyuzenkatagaki(t.get転入前方書());
        return tempEntity;
    }

    private ShotokuNendoParameter creatParameter() {
        ShotokuNendoParameter param = new ShotokuNendoParameter();
        FlexibleYear 処理年度 = processParameter.get処理年度();
        param.set出力対象(processParameter.get出力対象());
        param.set処理年度_0101(new FlexibleDate(処理年度.getYearValue(), 一月, INT_1));
        param.set処理年度_0102(new FlexibleDate(処理年度.getYearValue(), 一月, INT_2));
        param.set処理年度_plus1_0731(new FlexibleDate(処理年度.getYearValue() + INT_1, 七月, INT_31));
        param.set処理年度_plus1_0331(new FlexibleDate(処理年度.getYearValue() + INT_1, 三月, INT_31));
        param.set処理年度_minus18_0102(new FlexibleDate(処理年度.getYearValue() - INT_18, 一月, INT_2));
        param.set処理年度_minus39_0401(new FlexibleDate(処理年度.getYearValue() - INT_39, 四月, INT_1));
        return param;
    }

}
