/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShoteiShikkanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShoteiShikkanRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のList所定疾患施設療養費のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class ShoteiShikkanListCreateProcess extends BatchProcessBase<ShoteiShikkanRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get所定疾患施設療養費");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 所定疾患施設療養費List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        所定疾患施設療養費List = new BatchEntityCreatedTempTableWriter(ShoteiShikkanEntity.TABLE_NAME,
                ShoteiShikkanEntity.class);
    }

    @Override
    protected void process(ShoteiShikkanRelateEntity entity) {
        所定疾患施設療養費List.insert(get所定疾患施設療養費(entity));
    }

    private ShoteiShikkanEntity get所定疾患施設療養費(ShoteiShikkanRelateEntity entity) {
        ShoteiShikkanEntity 所定疾患施設療養費 = new ShoteiShikkanEntity();
        所定疾患施設療養費.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        所定疾患施設療養費.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        所定疾患施設療養費.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM().toDateString());
        所定疾患施設療養費.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        所定疾患施設療養費.set通し番号(entity.getDbt3017().getToshiNo());
        所定疾患施設療養費.set緊急時施設療養情報レコード順次番号(entity.getDbt3032().getRecodeJunjiNo());
        所定疾患施設療養費.set緊急時傷病名１(entity.getDbt3032().getKinkyuShobyoName1());
        所定疾患施設療養費.set緊急時傷病名２(entity.getDbt3032().getKinkyuShobyoName2());
        所定疾患施設療養費.set緊急時傷病名３(entity.getDbt3032().getKinkyuShobyoName3());
        所定疾患施設療養費.set緊急時治療開始年月日１(entity.getDbt3032().getKinkyuChiryoKaishiYMD1());
        所定疾患施設療養費.set緊急時治療開始年月日２(entity.getDbt3032().getKinkyuChiryoKaishiYMD2());
        所定疾患施設療養費.set緊急時治療開始年月日３(entity.getDbt3032().getKinkyuChiryoKaishiYMD3());
        所定疾患施設療養費.set往診日数(entity.getDbt3032().getOshinNissu());
        所定疾患施設療養費.set往診医療機関名(entity.getDbt3032().getOshinIryoKikanName());
        所定疾患施設療養費.set通院日数(entity.getDbt3032().getTsuinNissu());
        所定疾患施設療養費.set通院医療機関名(entity.getDbt3032().getTsuinIryoKikanName());
        所定疾患施設療養費.set緊急時治療管理単位数(entity.getDbt3032().getKinkyuChiryoKanriTanisu());
        所定疾患施設療養費.set緊急時治療管理日数(entity.getDbt3032().getKinkyuChiryoKanriNissu());
        所定疾患施設療養費.set緊急時治療管理小計(entity.getDbt3032().getKinkyuChiryoKanriSubTotal());
        所定疾患施設療養費.setリハビリテーション点数(entity.getDbt3032().getRehabilitationTensu());
        所定疾患施設療養費.set処置点数(entity.getDbt3032().getShochiTensu());
        所定疾患施設療養費.set手術点数(entity.getDbt3032().getShujutsuTensu());
        所定疾患施設療養費.set麻酔点数(entity.getDbt3032().getMasuiTensu());
        所定疾患施設療養費.set放射線治療点数(entity.getDbt3032().getHoshasenChiryoTensu());
        所定疾患施設療養費.set摘要１(entity.getDbt3032().getTekiyo1());
        所定疾患施設療養費.set摘要２(entity.getDbt3032().getTekiyo2());
        所定疾患施設療養費.set摘要３(entity.getDbt3032().getTekiyo3());
        所定疾患施設療養費.set摘要４(entity.getDbt3032().getTekiyo4());
        所定疾患施設療養費.set摘要５(entity.getDbt3032().getTekiyo5());
        所定疾患施設療養費.set摘要６(entity.getDbt3032().getTekiyo6());
        所定疾患施設療養費.set摘要７(entity.getDbt3032().getTekiyo7());
        所定疾患施設療養費.set摘要８(entity.getDbt3032().getTekiyo8());
        所定疾患施設療養費.set摘要９(entity.getDbt3032().getTekiyo9());
        所定疾患施設療養費.set摘要１０(entity.getDbt3032().getTekiyo10());
        所定疾患施設療養費.set摘要１１(entity.getDbt3032().getTekiyo11());
        所定疾患施設療養費.set摘要１２(entity.getDbt3032().getTekiyo12());
        所定疾患施設療養費.set摘要１３(entity.getDbt3032().getTekiyo13());
        所定疾患施設療養費.set摘要１４(entity.getDbt3032().getTekiyo14());
        所定疾患施設療養費.set摘要１５(entity.getDbt3032().getTekiyo15());
        所定疾患施設療養費.set摘要１６(entity.getDbt3032().getTekiyo16());
        所定疾患施設療養費.set摘要１７(entity.getDbt3032().getTekiyo17());
        所定疾患施設療養費.set摘要１８(entity.getDbt3032().getTekiyo18());
        所定疾患施設療養費.set摘要１９(entity.getDbt3032().getTekiyo19());
        所定疾患施設療養費.set摘要２０(entity.getDbt3032().getTekiyo20());
        所定疾患施設療養費.set緊急時施設療養費合計点数(entity.getDbt3032().getKinkyuShisetsuRyoyohiTotalTensu());
        所定疾患施設療養費.set所定疾患施設療養費傷病名１(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiShobyoName1());
        所定疾患施設療養費.set所定疾患施設療養費傷病名２(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiShobyoName2());
        所定疾患施設療養費.set所定疾患施設療養費傷病名３(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiShobyoName3());
        所定疾患施設療養費.set所定疾患施設療養費開始年月日１(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiKaishiYMD1());
        所定疾患施設療養費.set所定疾患施設療養費開始年月日２(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiKaishiYMD2());
        所定疾患施設療養費.set所定疾患施設療養費開始年月日３(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiKaishiYMD3());
        所定疾患施設療養費.set所定疾患施設療養費単位数(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiTanisu());
        所定疾患施設療養費.set所定疾患施設療養費日数(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiNissu());
        所定疾患施設療養費.set所定疾患施設療養費小計(entity.getDbt3032().getShoteiShikkanShisetsuRyoyohiSubTotal());
        所定疾患施設療養費.set後往診日数(entity.getDbt3032().getAtoOshinNissu());
        所定疾患施設療養費.set後通院日数(entity.getDbt3032().getAtoTsuinNissu());
        所定疾患施設療養費.set後緊急時治療管理単位数(entity.getDbt3032().getAtoKinkyuChiryoKanriTanisu());
        所定疾患施設療養費.set後緊急時治療管理日数(entity.getDbt3032().getAtoKinkyuChiryoKanriNissu());
        所定疾患施設療養費.set後リハビリテーション点数(entity.getDbt3032().getAtoRehabilitationTensu());
        所定疾患施設療養費.set後処置点数(entity.getDbt3032().getAtoShochiTensu());
        所定疾患施設療養費.set後手術点数(entity.getDbt3032().getAtoShujutsuTensu());
        所定疾患施設療養費.set後麻酔点数(entity.getDbt3032().getAtoMasuiTensu());
        所定疾患施設療養費.set後放射線治療点数(entity.getDbt3032().getAtoHoshasenChiryoTensu());
        所定疾患施設療養費.set後所定疾患施設療養費単位数(entity.getDbt3032().getAtoShoteiShikkanShisetsuRyoyoHiTanisu());
        所定疾患施設療養費.set後所定疾患施設療養費日数(entity.getDbt3032().getAtoShoteiShikkanShisetsuRyoyoHiNissu());
        所定疾患施設療養費.set再審査回数(entity.getDbt3032().getSaishinsaKaisu());
        所定疾患施設療養費.set過誤回数(entity.getDbt3032().getKagoKaisu());
        所定疾患施設療養費.set審査年月(entity.getDbt3032().getShinsaYM());
        所定疾患施設療養費.set名称(entity.getDbT3118_ryakusho());
        return 所定疾患施設療養費;
    }
}
