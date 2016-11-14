/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KyuuhuZissekiKougakuRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の高額介護サービス費からList基本のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class KyuuhuZissekiKougakuListCreateProcess extends BatchProcessBase<KyuuhuZissekiKougakuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get基本");
    private static final RString チルダ = new RString("～");
    private static final RString 居住サービス計画作成区分コード_1 = new RString("1");
    private static final RString 居住サービス計画作成区分コード_2 = new RString("2");
    private static final RString 居住サービス計画作成区分コード_3 = new RString("3");
    private static final RString 居住サービス計画作成区分コード_4 = new RString("4");
    private static final RString 入力識別番号_7171 = new RString("7171");
    private static final RString 入力識別番号_7172 = new RString("7172");
    private static final RString 入力識別番号_7173 = new RString("7173");
    private static final RString 入力識別番号_7174 = new RString("7174");
    private static final RString 入力識別番号_2171 = new RString("2171");
    private static final RString 入力識別番号_2172 = new RString("2172");
    private static final RString 入力識別番号_2173 = new RString("2173");
    private static final RString 入力識別番号_2174 = new RString("2174");
    private static final RString 入力識別番号_7181 = new RString("7181");
    private static final RString 入力識別番号_7182 = new RString("7182");
    private static final RString 入力識別番号_7183 = new RString("7183");
    private static final RString 入力識別番号_2181 = new RString("2181");
    private static final RString 入力識別番号_2182 = new RString("2182");
    private static final RString 入力識別番号_2183 = new RString("2183");
    private static final RString 入力識別番号_7191 = new RString("7191");
    private static final RString 入力識別番号_7192 = new RString("7192");
    private static final RString 入力識別番号_7193 = new RString("7193");
    private static final RString 入力識別番号_7194 = new RString("7194");
    private static final RString 入力識別番号_7195 = new RString("7195");
    private static final RString 入力識別番号_2191 = new RString("2191");
    private static final RString 入力識別番号_2192 = new RString("2192");
    private static final RString 入力識別番号_2193 = new RString("2193");
    private static final RString 入力識別番号_2194 = new RString("2194");
    private static final RString 入力識別番号_2195 = new RString("2195");
    private static final RString 入力識別番号_71A1 = new RString("71A1");
    private static final RString 入力識別番号_71A2 = new RString("71A2");
    private static final RString 入力識別番号_71A3 = new RString("71A3");
    private static final RString 入力識別番号_21A1 = new RString("21A1");
    private static final RString 入力識別番号_21A2 = new RString("21A2");
    private static final RString 入力識別番号_21A3 = new RString("21A3");
    private static final RString 入力識別番号_716X = new RString("716X");
    private static final RString 入力識別番号_216X = new RString("216X");
    private static final RString 入力識別番号_71AX = new RString("71AX");
    private static final RString 入力識別番号_21AX = new RString("21AX");
    private static final RString 入力識別番号_2155 = new RString("2155");
    private static final RString 入力識別番号_2156 = new RString("2156");
    private static final RString 入力識別番号_7155 = new RString("7155");
    private static final RString 入力識別番号_7156 = new RString("7156");
    private static final RString サービス提供年月_200510 = new RString("200510");
    private static final RString 入所_院_前 = new RString("201104");
    private static final RString 区分_基本 = new RString("1");

    private static final int 居住サービス計画事業者名_LENGTH = 20;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 基本List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        基本List = new BatchEntityCreatedTempTableWriter(KihonEntity.TABLE_NAME,
                KihonEntity.class);
    }

    @Override
    protected void process(KyuuhuZissekiKougakuRelateEntity entity) {
        基本List.insert(set基本List(entity));
    }

    private KihonEntity set基本List(KyuuhuZissekiKougakuRelateEntity entity) {
        KihonEntity 基本entity = new KihonEntity();
        RString 入力識別番号 = entity.getDbt3028_inputShikibetsuNo();
        RString サービス提供年月 = entity.getDbt3028_serviceTeikyoYM();
        基本entity.set入力識別番号(入力識別番号);
        基本entity.set被保険者番号(entity.getDbt3028_hiHokenshaNo());
        基本entity.setサービス提供年月(サービス提供年月);
        基本entity.set給付実績区分コード(KyufuJissekiKubun.toValue(entity.getDbt3028_kyufuJissekiKubunCode()).get名称());
        基本entity.set通し番号(entity.getDbt3028_toshiNo());
        基本entity.set生年月日(entity.getPsm_tmp2_seinengappiYMD());
        基本entity.set性別コード(entity.getPsm_tmp2_seibetsuCode());
        基本entity.set証記載保険者番号(entity.getDbt3028_shokisaiHokenshaNo());
        基本entity.set審査年月(entity.getDbt3028_shinsaYM());
        基本entity.set整理番号(entity.getDbt3028_seiriNo());
        基本entity.set出力様式(entity.getDbT3118_ryakusho());
        RString 名称 = entity.getDbT3118_meisho();
        if (名称.length() <= 居住サービス計画事業者名_LENGTH) {
            基本entity.set出力様式１(名称);
            基本entity.set出力様式２(RString.EMPTY);
        } else {
            基本entity.set出力様式１(名称.substring(0, 居住サービス計画事業者名_LENGTH));
            基本entity.set出力様式２(名称.substring(居住サービス計画事業者名_LENGTH));
        }
        List<RString> 入力識別番号List = new ArrayList<>();
        入力識別番号List.add(入力識別番号_716X);
        入力識別番号List.add(入力識別番号_216X);
        入力識別番号List.add(入力識別番号_71AX);
        入力識別番号List.add(入力識別番号_21AX);
        入力識別番号List.add(入力識別番号_2155);
        入力識別番号List.add(入力識別番号_2156);
        入力識別番号List.add(入力識別番号_2194);
        入力識別番号List.add(入力識別番号_7155);
        入力識別番号List.add(入力識別番号_7156);
        入力識別番号List.add(入力識別番号_7194);
        基本entity.set基本ヘッダー１(get基本ヘッダー(入力識別番号, サービス提供年月, 入力識別番号List));
        基本entity.set基本ヘッダー２(new RString("請求額"));
        基本entity.set基本ヘッダー3(new RString("特定入所者介"));
        基本entity.set基本ヘッダー４(new RString("護費等請求額"));
        基本entity.set被保険者氏名カナ(entity.getPsm_tmp2_kanaMeisho());
        基本entity.set被保険者氏名(entity.getPsm_tmp2_meisho());
        基本entity.set世帯コード(entity.getPsm_tmp2_setaiCode());
        基本entity.set住所コード(entity.getPsm_tmp2_zenkokuJushoCode());
        基本entity.set住所(entity.getPsm_tmp2_jusho());
        基本entity.set行政区コード(entity.getPsm_tmp2_gyoseikuCode());
        基本entity.set行政区(entity.getPsm_tmp2_gyoseikuName());
        基本entity.set住民コード(entity.getDbt1001_tmp2_shikibetsuCode());
        基本entity.set区分(区分_基本);
        基本entity.set高額受付年月日(entity.getDbt3028_uketsukeYMD());
        基本entity.set高額決定年月日(entity.getDbt3028_ketteiYMD());
        基本entity.set高額公費１負担番号(entity.getDbt3028_kohi1FutanNo());
        基本entity.set高額公費２負担番号(entity.getDbt3028_kohi2FutanNo());
        基本entity.set高額公費３負担番号(entity.getDbt3028_kohi3FutanNo());
        基本entity.set高額利用者負担額(entity.getDbt3028_riyoshaFutangaku());
        基本entity.set高額公費１負担額(entity.getDbt3028_kohi1Futangaku());
        基本entity.set高額公費２負担額(entity.getDbt3028_kohi2Futangaku());
        基本entity.set高額公費３負担額(entity.getDbt3028_kohi3Futangaku());
        基本entity.set高額支給額(entity.getDbt3028_shikyugaku());
        基本entity.set高額公費１支給額(entity.getDbt3028_kohi1Shikyugaku());
        基本entity.set高額公費２支給額(entity.getDbt3028_kohi2Shikyugaku());
        基本entity.set高額公費３支給額(entity.getDbt3028_kohi3Shikyugaku());
        return 基本entity;
    }

    private RString get基本ヘッダー(RString 入力識別番号, RString サービス提供年月, List<RString> 入力識別番号List) {
        if (入力識別番号List.contains(入力識別番号)
                && new FlexibleYearMonth(サービス提供年月_200510).isBeforeOrEquals(new FlexibleYearMonth(サービス提供年月))) {
            return new RString("特別療養費");
        } else {
            return new RString("食事提供費");
        }
    }
}
