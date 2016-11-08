/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * List給付実績緊急時の施設療養のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class KinkyuuziShisetuRyouyouCreateProcess extends BatchProcessBase<KinkyuuziShisetuRyouyouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get緊急時施設療養");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 緊急List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        緊急List = new BatchEntityCreatedTempTableWriter(KinkyuuziShisetuRyouyouEntity.TABLE_NAME,
                KinkyuuziShisetuRyouyouEntity.class);
    }

    @Override
    protected void process(KinkyuuziShisetuRyouyouRelateEntity entity) {
        緊急List.insert(get給付実績緊急時施設療養データ(entity));

    }

    private KinkyuuziShisetuRyouyouEntity get給付実績緊急時施設療養データ(KinkyuuziShisetuRyouyouRelateEntity entity) {
        KinkyuuziShisetuRyouyouEntity 緊急データ = new KinkyuuziShisetuRyouyouEntity();
        緊急データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        緊急データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        緊急データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        緊急データ.set事業所番号(entity.getDbt3017().getJigyoshoNo());
        緊急データ.set通し番号(entity.getDbt3017().getToshiNo());
        緊急データ.set順次番号(entity.getDbt3019().getRecodeJunjiNo());
        緊急データ.set緊急時傷病名１(entity.getDbt3019().getKinkyuShobyoName1());
        緊急データ.set緊急時傷病名２(entity.getDbt3019().getKinkyuShobyoName2());
        緊急データ.set緊急時傷病名３(entity.getDbt3019().getKinkyuShobyoName3());
        緊急データ.set緊急時治療開始年月日１(entity.getDbt3019().getKinkyuChiryoKaishiYMD1());
        緊急データ.set緊急時治療開始年月日２(entity.getDbt3019().getKinkyuChiryoKaishiYMD2());
        緊急データ.set緊急時治療開始年月日３(entity.getDbt3019().getKinkyuChiryoKaishiYMD3());
        緊急データ.set往診日数(entity.getDbt3019().getOshinNissu());
        緊急データ.set通院日数(entity.getDbt3019().getTsuinNissu());
        緊急データ.set後往診日数(entity.getDbt3019().getAtoOshinNissu());
        緊急データ.set後通院日数(entity.getDbt3019().getAtoTsuinNissu());
        緊急データ.set往診医療機関名(entity.getDbt3019().getOshinIryoKikanName());
        緊急データ.set通院医療機関名(entity.getDbt3019().getTsuinIryoKikanName());
        緊急データ.set緊急時治療管理点数(entity.getDbt3019().getKinkyuChiryoKanriTanisu());
        緊急データ.set緊急時治療管理日数(entity.getDbt3019().getKinkyuChiryoKanriNissu());
        緊急データ.set緊急時治療管理小計(entity.getDbt3019().getKinkyuChiryoKanriSubTotal());
        緊急データ.setリハビリテーション点数(entity.getDbt3019().getRehabilitationTensu());
        緊急データ.set処置点数(entity.getDbt3019().getShochiTensu());
        緊急データ.set手術点数(entity.getDbt3019().getShujutsuTensu());
        緊急データ.set麻酔点数(entity.getDbt3019().getMasuiTensu());
        緊急データ.set放射線治療点数(entity.getDbt3019().getHoshasenChiryoTensu());
        緊急データ.set後リハビリテーション点数(entity.getDbt3019().getAtoRehabilitationTensu());
        緊急データ.set後処置点数(entity.getDbt3019().getAtoShochiTensu());
        緊急データ.set後手術点数(entity.getDbt3019().getAtoShujutsuTensu());
        緊急データ.set後麻酔点数(entity.getDbt3019().getAtoMasuiTensu());
        緊急データ.set後放射線治療点数(entity.getDbt3019().getAtoHoshasenChiryoTensu());
        緊急データ.set後緊急時治療管理点数(entity.getDbt3019().getAtoKinkyuChiryoKanriTanisu());
        緊急データ.set後緊急時治療管理日数(entity.getDbt3019().getAtoKinkyuChiryoKanriNissu());
        緊急データ.set再審査回数(entity.getDbt3019().getSaishinsaKaisu());
        緊急データ.set過誤回数(entity.getDbt3019().getKagoKaisu());
        緊急データ.set審査年月(entity.getDbt3019().getShinsaYM());
        緊急データ.set摘要１(entity.getDbt3019().getTekiyo1());
        緊急データ.set摘要２(entity.getDbt3019().getTekiyo2());
        緊急データ.set摘要３(entity.getDbt3019().getTekiyo3());
        緊急データ.set摘要４(entity.getDbt3019().getTekiyo4());
        緊急データ.set摘要５(entity.getDbt3019().getTekiyo5());
        緊急データ.set摘要６(entity.getDbt3019().getTekiyo6());
        緊急データ.set摘要７(entity.getDbt3019().getTekiyo7());
        緊急データ.set摘要８(entity.getDbt3019().getTekiyo8());
        緊急データ.set摘要９(entity.getDbt3019().getTekiyo9());
        緊急データ.set摘要１０(entity.getDbt3019().getTekiyo10());
        緊急データ.set摘要１１(entity.getDbt3019().getTekiyo11());
        緊急データ.set摘要１２(entity.getDbt3019().getTekiyo12());
        緊急データ.set摘要１３(entity.getDbt3019().getTekiyo13());
        緊急データ.set摘要１４(entity.getDbt3019().getTekiyo14());
        緊急データ.set摘要１５(entity.getDbt3019().getTekiyo15());
        緊急データ.set摘要１６(entity.getDbt3019().getTekiyo16());
        緊急データ.set摘要１７(entity.getDbt3019().getTekiyo17());
        緊急データ.set摘要１８(entity.getDbt3019().getTekiyo18());
        緊急データ.set摘要１９(entity.getDbt3019().getTekiyo19());
        緊急データ.set摘要２０(entity.getDbt3019().getTekiyo20());
        緊急データ.set緊急時施設療養費合計点数(entity.getDbt3019().getKinkyuShisetsuRyoyoHiTotalTensu());
        return 緊急データ;

    }
}
