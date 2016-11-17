/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KyufuJissekiSetteiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoTop3Keta;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1510KyufuJissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1514ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.KyuhuJissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 統計用給付実績データ作成のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class TokeiyoKyuhuJissekiDataSakuseiProcess extends BatchProcessBase<DbWT1510KyufuJissekiKihonEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.selectAll");

    private static final RString TABLE_給付実績基本一時 = new RString("DbWT1510KyufuJissekiKihon");
    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    private static final RString TABLE_処理結果確認リスト一時 = new RString("DbWT1514ShoriKekkaKakuninList");
    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final RString 最大サービス計画費明細行番号 = new RString("99");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果確認リスト一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績基本一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;
    RiyoJokyoTokeihyoMeisaiListSakuseiService service;

    List<KyuhuJissekiMeisaiEntity> 給付実績明細;
    List<DbT3022KyufujissekiShokujiHiyoEntity> 給付実績食事費用;
    List<DbT3025KyufujissekiKyotakuServiceEntity> 給付実績居宅サービス計画費;
    List<DbT3026KyufujissekiFukushiYoguHanbaihiEntity> 給付実績福祉用具販売費;
    List<DbT3027KyufujissekiJutakuKaishuhiEntity> 給付実績住宅改修費;
    List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> 給付実績特定入所者介護サービス費用;
    List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> 給付実績社会福祉法人軽減額;
    List<DbT3033KyufujissekiShukeiEntity> 給付実績集計;

    List<KyuhuJissekiMeisaiEntity> 給付実績明細ワーク;
    List<DbT3022KyufujissekiShokujiHiyoEntity> 給付実績食事費用ワーク;
    List<DbT3025KyufujissekiKyotakuServiceEntity> 給付実績居宅サービス計画費ワーク;
    List<DbT3026KyufujissekiFukushiYoguHanbaihiEntity> 給付実績福祉用具販売費ワーク;
    List<DbT3027KyufujissekiJutakuKaishuhiEntity> 給付実績住宅改修費ワーク;
    List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> 給付実績特定入所者介護サービス費用ワーク;
    List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> 給付実績社会福祉法人軽減額ワーク;
    List<DbT3033KyufujissekiShukeiEntity> 給付実績集計ワーク;
    FlexibleYearMonth 制度改正施行年月H21;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void initialize() {
        IRiyoJokyoTokeihyoMeisaiListSakuseiMapper mapper = getMapper(IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.class);
        給付実績明細 = mapper.select給付実績明細();
        給付実績食事費用 = mapper.select給付実績食事費用();
        給付実績居宅サービス計画費 = mapper.select給付実績居宅サービス計画費();
        給付実績福祉用具販売費 = mapper.select給付実績福祉用具販売費();
        給付実績住宅改修費 = mapper.select給付実績住宅改修費();
        給付実績特定入所者介護サービス費用 = mapper.select給付実績特定入所者介護サービス費用();
        給付実績社会福祉法人軽減額 = mapper.select給付実績社会福祉法人軽減額();
        給付実績集計 = mapper.select給付実績集計();
        制度改正施行年月H21 = new FlexibleDate(DbBusinessConfig.
                get(ConfigNameDBU.制度改正施行日_平成２１年０４月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)).getYearMonth();
    }

    @Override
    protected void createWriter() {
        給付実績基本一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_給付実績基本一時,
                DbWT1510KyufuJissekiKihonEntity.class);
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
        処理結果確認リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果確認リスト一時,
                DbWT1514ShoriKekkaKakuninListEntity.class);
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
    }

    private void return給付実績明細ワーク(RString キー項目) {
        for (KyuhuJissekiMeisaiEntity 給付実績 : 給付実績明細) {
            RString key = createキー項目(給付実績.getEntity().getHiHokenshaNo(), 給付実績.getEntity().getServiceTeikyoYM(),
                    給付実績.getEntity().getJigyoshoNo(), 給付実績.getEntity().getInputShikibetsuNo(),
                    給付実績.getEntity().getToshiNo());
            if (キー項目.equals(key)) {
                給付実績明細ワーク.add(給付実績);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク2(RString キー項目) {
        for (DbT3022KyufujissekiShokujiHiyoEntity 給付実績食事 : 給付実績食事費用) {
            RString key = createキー項目(給付実績食事.getHiHokenshaNo(), 給付実績食事.getServiceTeikyoYM(),
                    給付実績食事.getJigyoshoNo(), 給付実績食事.getInputShikibetsuNo(), 給付実績食事.getToshiNo());
            if (キー項目.equals(key)) {
                給付実績食事費用ワーク.add(給付実績食事);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク3(RString キー項目) {
        for (DbT3025KyufujissekiKyotakuServiceEntity サービス計画 : 給付実績居宅サービス計画費) {
            RString key = createキー項目(サービス計画.getHiHokenshaNo(), サービス計画.getServiceTeikyoYM(),
                    サービス計画.getJigyoshoNo(), サービス計画.getInputShikibetsuNo(), サービス計画.getToshiNo());
            if (キー項目.equals(key)) {
                給付実績居宅サービス計画費ワーク.add(サービス計画);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク4(RString キー項目) {
        for (DbT3026KyufujissekiFukushiYoguHanbaihiEntity 給付実績福祉 : 給付実績福祉用具販売費) {
            RString key = createキー項目(給付実績福祉.getHiHokenshaNo(), 給付実績福祉.getServiceTeikyoYM(),
                    給付実績福祉.getJigyoshoNo(), 給付実績福祉.getInputShikibetsuNo(), 給付実績福祉.getToshiNo());
            if (キー項目.equals(key)) {
                給付実績福祉用具販売費ワーク.add(給付実績福祉);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク5(RString キー項目) {
        for (DbT3027KyufujissekiJutakuKaishuhiEntity 給付実績住宅 : 給付実績住宅改修費) {
            RString key = createキー項目(給付実績住宅.getHiHokenshaNo(), 給付実績住宅.getServiceTeikyoYM(),
                    給付実績住宅.getJigyoshoNo(), 給付実績住宅.getInputShikibetsuNo(), 給付実績住宅.getToshiNo());
            if (キー項目.equals(key)) {
                給付実績住宅改修費ワーク.add(給付実績住宅);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク6(RString キー項目) {
        for (DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity 特定入所者 : 給付実績特定入所者介護サービス費用) {
            RString key = createキー項目(特定入所者.getHiHokenshaNo(), 特定入所者.getServiceTeikyoYM(),
                    特定入所者.getJigyoshoNo(), 特定入所者.getInputShikibetsuNo(), 特定入所者.getToshiNo());
            if (キー項目.equals(key)) {
                給付実績特定入所者介護サービス費用ワーク.add(特定入所者);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク7(RString キー項目) {
        for (DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity 社会福祉 : 給付実績社会福祉法人軽減額) {
            RString key = createキー項目(社会福祉.getHiHokenshaNo(), 社会福祉.getServiceTeikyoYM(),
                    社会福祉.getJigyoshoNo(), 社会福祉.getInputShikibetsuNo(), 社会福祉.getToshiNo());
            if (キー項目.equals(key)) {
                給付実績社会福祉法人軽減額ワーク.add(社会福祉);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク8(RString キー項目) {
        for (DbT3033KyufujissekiShukeiEntity 集計 : 給付実績集計) {
            RString key = createキー項目(集計.getHiHokenshaNo(), 集計.getServiceTeikyoYM(),
                    集計.getJigyoshoNo(), 集計.getInputShikibetsuNo(), 集計.getToshiNo());
            if (キー項目.equals(key)) {
                給付実績集計ワーク.add(集計);
            } else if (キー項目.compareTo(key) < 0) {
                break;
            }
        }
    }

    private void return給付実績明細ワーク9(DbWT1510KyufuJissekiKihonEntity entity) {
        RString 入力識別番号上3桁 = entity.getInputShikibetsuNo().value().substring(ZERO, THREE);
        if (入力識別番号上3桁.equals(NyuryokuShikibetsuNoTop3Keta.現物_居宅サービス計画費.getコード())
                || 入力識別番号上3桁.equals(NyuryokuShikibetsuNoTop3Keta.償還_居宅サービス計画費.getコード())) {
            if (entity.getServiceTeikyoYM().isBefore(制度改正施行年月H21)) {
                for (DbT3025KyufujissekiKyotakuServiceEntity 計画費 : 給付実績居宅サービス計画費ワーク) {
                    利用状況統計表一時TBL.insert(service.create給付実績データ(entity, 計画費));
                }
            } else {
                給付実績データ作成(entity);
            }
        } else {
            int 福祉件数 = 給付実績福祉用具販売費ワーク.size();
            int 住宅件数 = 給付実績住宅改修費ワーク.size();
            for (DbT3033KyufujissekiShukeiEntity 集計 : 給付実績集計ワーク) {
                service.create給付実績データ集計(entity, 集計, 福祉件数, 住宅件数, 給付実績明細ワーク,
                        給付実績食事費用ワーク, 給付実績特定入所者介護サービス費用ワーク, 給付実績社会福祉法人軽減額ワーク,
                        処理結果確認リスト一時TBL);
            }
        }
    }

    @Override
    protected void process(DbWT1510KyufuJissekiKihonEntity entity) {
        clear();
        RString キー項目 = createキー項目(entity.getHiHokenshaNo(), entity.getServiceTeikyoYM(), entity.getJigyoshoNo(),
                entity.getInputShikibetsuNo(), entity.getToshiNo());
        return給付実績明細ワーク(キー項目);
        if ((KyufuJissekiSetteiKubun.設定不可.getコード().equals(entity.getMeisaiSetteiKubun()) && !給付実績明細ワーク.isEmpty())
                || (KyufuJissekiSetteiKubun.必須.getコード().equals(entity.getMeisaiSetteiKubun()) && 給付実績明細ワーク.isEmpty())) {

            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク2(キー項目);
        if ((KyufuJissekiSetteiKubun.設定不可.getコード().equals(entity.getShokujiHiyosetteiKubun()) && !給付実績食事費用ワーク.isEmpty())
                || (KyufuJissekiSetteiKubun.必須.getコード().equals(entity.getShokujiHiyosetteiKubun()) && 給付実績食事費用ワーク.isEmpty())) {

            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク3(キー項目);
        if ((KyufuJissekiSetteiKubun.設定不可.getコード().equals(entity.getKyotakuKeikakuSetteiKubun()) && !給付実績居宅サービス計画費ワーク.isEmpty())
                || (KyufuJissekiSetteiKubun.必須.getコード().equals(entity.getKyotakuKeikakuSetteiKubun()) && 給付実績居宅サービス計画費ワーク.isEmpty())) {

            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク4(キー項目);
        if (isEntity(entity, 給付実績福祉用具販売費ワーク)) {
            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク5(キー項目);
        if (isEntity(entity, 給付実績住宅改修費ワーク)) {
            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク6(キー項目);
        if (isEntity(entity, 給付実績特定入所者介護サービス費用ワーク)) {
            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク7(キー項目);
        if (isEntity(entity, 給付実績社会福祉法人軽減額ワーク)) {
            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク8(キー項目);
        if (isEntity(entity, 給付実績集計ワーク)) {
            処理結果確認リスト一時TBL.insert(service.createマスタ構成不正Entity(entity));
            return;
        }
        return給付実績明細ワーク9(entity);
    }

    private boolean isEntity(DbWT1510KyufuJissekiKihonEntity entity, List listEntity) {
        return (KyufuJissekiSetteiKubun.設定不可.getコード().equals(entity.getShukeiSetteiKubun()) && !listEntity.isEmpty())
                || (KyufuJissekiSetteiKubun.必須.getコード().equals(entity.getShukeiSetteiKubun()) && listEntity.isEmpty());
    }

    private void clear() {
        給付実績明細ワーク = new ArrayList<>();
        給付実績食事費用ワーク = new ArrayList<>();
        給付実績居宅サービス計画費ワーク = new ArrayList<>();
        給付実績福祉用具販売費ワーク = new ArrayList<>();
        給付実績住宅改修費ワーク = new ArrayList<>();
        給付実績特定入所者介護サービス費用ワーク = new ArrayList<>();
        給付実績社会福祉法人軽減額ワーク = new ArrayList<>();
        給付実績集計ワーク = new ArrayList<>();
    }

    private void 給付実績データ作成(DbWT1510KyufuJissekiKihonEntity entity) {
        Integer 後回数 = ZERO;
        for (DbT3025KyufujissekiKyotakuServiceEntity 計画費 : 給付実績居宅サービス計画費ワーク) {
            後回数 = 後回数 + 計画費.getAtoKaisu();
            if (最大サービス計画費明細行番号.equals(計画費.getServicePlanhiMeisaiLineNo())) {
                DbWT1513RiyoJokyoTokeihyoEntity 給付実績データ = service.create給付実績データ(entity, 計画費);
                給付実績データ.setNissuKaisu(new RString(後回数.toString()));
                給付実績データ.setHokenTanisu(RiyoJokyoTokeihyoMeisaiListSakuseiService.decimaltoRString(計画費.getAtoServiceTanisuTotal()));
                利用状況統計表一時TBL.insert(service.create給付実績データ(entity, 計画費));
            }
        }
    }

    private RString createキー項目(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号, NyuryokuShikibetsuNo 入力識別番号, RString 通し番号) {
        RStringBuilder key = new RStringBuilder();
        key.append(被保険者番号.value());
        key.append(サービス提供年月.toDateString());
        key.append(事業者番号.value());
        key.append(入力識別番号.value());
        key.append(通し番号);
        return key.toRString();
    }
}
