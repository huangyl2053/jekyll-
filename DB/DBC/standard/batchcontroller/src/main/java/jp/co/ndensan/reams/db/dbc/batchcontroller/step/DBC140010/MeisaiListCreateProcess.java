/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 受給者給付実績台帳のList明細のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class MeisaiListCreateProcess extends BatchProcessBase<MeisaiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get明細");
    private static final RString 明細_区分 = new RString("1");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 明細List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        明細List = new BatchEntityCreatedTempTableWriter(MeisaiEntity.TABLE_NAME,
                MeisaiEntity.class);
    }

    @Override
    protected void process(MeisaiRelateEntity entity) {
        明細List.insert(get明細データ(entity));
    }

    private MeisaiEntity get明細データ(MeisaiRelateEntity entity) {
        MeisaiEntity 明細データ = new MeisaiEntity();
        明細データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        明細データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        明細データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        明細データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        明細データ.set通し番号(entity.getDbt3017().getToshiNo());
        明細データ.setサービス種類コード(entity.getDbt3018().getServiceShuruiCode().value());
        明細データ.setサービス項目コード(entity.getDbt3018().getServiceKomokuCode().value());
        明細データ.setサービス内容(entity.getServiceName());
        明細データ.set単位数(entity.getDbt3018().getTanisu());
        明細データ.set後単位数(entity.getDbt3018().getAtoTanisu());
        明細データ.set単位数識別(get単位数識別(entity.getTanisuShikibetsuCode()));
        明細データ.set日数回数(entity.getDbt3018().getNissuKaisu());
        明細データ.set後日数回数(entity.getDbt3018().getAtoNissuKaisu());
        明細データ.setサービス単位数(entity.getDbt3018().getServiceTanisu());
        明細データ.set後サービス単位数(entity.getDbt3018().getAtoServiceTanisu());
        明細データ.set公費１対象日数回数(entity.getDbt3018().getKohi1TaishoNissuKaisu());
        明細データ.set後公費１対象日数回数(entity.getDbt3018().getAtoKohi1TaishoNissuKaisu());
        明細データ.set公費１対象サービス点数(entity.getDbt3018().getKohi1TaishoServiceTanisu());
        明細データ.set後公費１対象サービス点数(entity.getDbt3018().getAtoKohi1TaishoServiceTanisu());
        明細データ.set公費２対象日数回数(entity.getDbt3018().getKohi2TaishoNissuKaisu());
        明細データ.set後公費２対象日数回数(entity.getDbt3018().getAtoKohi2TaishoNissukaisu());
        明細データ.set公費２対象サービス点数(entity.getDbt3018().getKohi2TaishoServiceTanisu());
        明細データ.set後公費２対象サービス点数(entity.getDbt3018().getAtoKohi2TaishoServiceTanisu());
        明細データ.set公費３対象日数回数(entity.getDbt3018().getKohi3TaishoNissuKaisu());
        明細データ.set後公費３対象日数回数(entity.getDbt3018().getAtoKohi3TaishoNissuKaisu());
        明細データ.set公費３対象サービス点数(entity.getDbt3018().getKohi3TaishoServiceTanisu());
        明細データ.set後公費３対象サービス点数(entity.getDbt3018().getAtoKohi3TaishoServiceTanisu());
        明細データ.set摘要(entity.getDbt3018().getTekiyo());
        明細データ.set再審査回数(entity.getDbt3018().getSaishinsaKaisu());
        明細データ.set過誤回数(entity.getDbt3018().getKagoKaisu());
        明細データ.set審査年月(entity.getDbt3018().getShinsaYM());
        明細データ.set区分(明細_区分);
        return 明細データ;
    }

    private RString get単位数識別(RString tanisuShikibetsuCode) {
        if (RString.isNullOrEmpty(tanisuShikibetsuCode)) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(DBCCodeShubetsu.単位数識別コード.getコード(), new Code(tanisuShikibetsuCode));
    }

}
