/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBDZ00001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.processprm.hanteiyoukonsakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengakutaishoshahanteiyoukonsakusei.TaishoShaHanteiYoukonkyoItokiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengakutaishoshahanteiyoukonsakusei.TaishouJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDBTZ0001_減免減額対象者判定用根拠作成_process処理クラスです。
 *
 * @reamsid_L DBD-3710-050 liuwei2
 */
public class GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei extends BatchProcessBase<TaishouJohoEntity> {

    private static final RString MYBATIS_SELECT_ID_対象情報 = new RString("jp.co.ndensan.reams.db.dbd.persistence"
            + ".db.mapper.relate.gemmengengakutaishoshahanteiyoukonsakusei.ITaishouJohoMapper.get対象情報");
    private GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter processParamter;
    private IKojin iKojin;
    private ISetai isetai;
    private static final RString 本人 = HonninKubun.本人.getCode();
    private static final RString 第1段階 = RiyoshaFutanDankai.第一段階.getコード();
    private static final RString 第2段階 = RiyoshaFutanDankai.第二段階.getコード();
    private static final RString 第3段階 = RiyoshaFutanDankai.第三段階.getコード();
    private static final RString 第4段階 = RiyoshaFutanDankai.第四段階.getコード();
    private static final RString 課税区分_課税 = KazeiKubun.課税.getコード();
    private List<TaishouJohoEntity> 被保険者番号list;
    private List<RString> 課税区分list;
    private List<Decimal> 金額list;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter youkonkyoItokiTemp;

    @Override
    protected void initialize() {
        被保険者番号list = new ArrayList<>();
        課税区分list = new ArrayList<>();
        金額list = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_対象情報, processParamter.toGemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        youkonkyoItokiTemp = new BatchEntityCreatedTempTableWriter(TaishoShaHanteiYoukonkyoItokiTempTableEntity.TABLE_NAME,
                TaishoShaHanteiYoukonkyoItokiTempTableEntity.class);
    }

    @Override
    protected void process(TaishouJohoEntity list) {
        if (被保険者番号list.isEmpty()) {
            被保険者番号list.add(list);
            課税区分list.add(list.get課税区分_住民税減免前());
            get合計金額(list);
        } else if (被保険者番号list.get(0).get被保険者番号().equals(list.get被保険者番号())) {
            被保険者番号list.add(list);
            課税区分list.add(list.get課税区分_住民税減免前());
            get合計金額(list);
        } else {
            TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable = editorTaishouJohoEntity(被保険者番号list, 課税区分list, 金額list);
            if (tempTable.get被保険者番号() != null) {
                youkonkyoItokiTemp.insert(tempTable);
            }
            被保険者番号list.clear();
            課税区分list.clear();
            金額list.clear();
            被保険者番号list.add(list);
            課税区分list.add(list.get課税区分_住民税減免前());
            get合計金額(list);
        }
    }

    @Override
    protected void afterExecute() {
        TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable = editorTaishouJohoEntity(被保険者番号list, 課税区分list, 金額list);
        youkonkyoItokiTemp.insert(tempTable);
    }

    private TaishoShaHanteiYoukonkyoItokiTempTableEntity editorTaishouJohoEntity(List<TaishouJohoEntity> recordList,
            List<RString> kuBunList, List<Decimal> kingakuList) {
        TaishoShaHanteiYoukonkyoItokiTempTableEntity entity = new TaishoShaHanteiYoukonkyoItokiTempTableEntity();
        entity.set世帯課税区分(SetaiKazeiKubun.非課税.getコード());
        entity.set所得税課税世帯(Boolean.FALSE);
        for (TaishouJohoEntity item : recordList) {
            if (本人.equals(item.get本人区分()) && ((item.get識別コード_生活保護受給者() != null
                    && !item.get識別コード_生活保護受給者().isEmpty())
                    || (item.get識別コード_老齢福祉年金受給者() != null && !item.get識別コード_老齢福祉年金受給者().isEmpty()))) {
                entity.set利用者負担段階(第1段階);

            } else {
                if (kuBunList != null && set利用者負担段階四(kuBunList)) {
                    entity.set利用者負担段階(第4段階);
                } else {
                    if (kingakuList != null && set利用者負担段階二(kingakuList)) {
                        entity.set利用者負担段階(第2段階);
                    } else {
                        entity.set利用者負担段階(第3段階);
                    }
                }
            }
            if (本人.equals(item.get本人区分())) {
                setTaishouJohoEntity(item, entity);
            }
            if (課税区分_課税.equals(item.get課税区分_住民税減免前())) {
                entity.set世帯課税区分(SetaiKazeiKubun.課税.getコード());
            }
            if (item.get課税所得額() != null && 0 < item.get課税所得額().longValue()) {
                entity.set所得税課税者(Boolean.TRUE);
            }
        }
        return entity;
    }

    private void get合計金額(TaishouJohoEntity list) {
        if (list.get合計所得金額() == null) {
            list.set合計所得金額(Decimal.ZERO);
        }
        if (list.get年金収入額() == null) {
            list.set年金収入額(Decimal.ZERO);
        }
        if (list.get非課税年金勘案額() == null) {
            list.set非課税年金勘案額(Decimal.ZERO);
        }
        if (!本人.equals(list.get本人区分())) {
            金額list.add(list.get合計所得金額().add(list.get年金収入額()).add(list.get非課税年金勘案額()));
        }
    }

    private boolean set利用者負担段階四(List<RString> kuBunList) {
        for (RString item : kuBunList) {
            if (課税区分_課税.equals(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean set利用者負担段階二(List<Decimal> kingakuList) {
        for (Decimal item : kingakuList) {
            if (0 <= processParamter.getNumber().compareTo(item)) {
                return true;
            }
        }
        return false;
    }

    private void setTaishouJohoEntity(TaishouJohoEntity item, TaishoShaHanteiYoukonkyoItokiTempTableEntity entity) {
        isetai = get世帯(item.get識別コード(), item.get基準日());
        iKojin = get世帯(item.get識別コード(), item.get基準日()).get世帯員(item.get識別コード());
        if (item.get被保険者番号() != null) {
            entity.set被保険者番号(item.get被保険者番号());
        } else {
            entity.set被保険者番号(HihokenshaNo.EMPTY);
        }
        if (item.get識別コード() != null) {
            entity.set本人識別コード(item.get識別コード());
        } else {
            entity.set本人識別コード(ShikibetsuCode.EMPTY);
        }

        if (item.get課税区分_住民税減免前() != null) {
            entity.set本人課税区分(item.get課税区分_住民税減免前());
        } else {
            entity.set本人課税区分(RString.EMPTY);
        }

        if (item.get識別コード_生活保護受給者() != null && !item.get識別コード_生活保護受給者().isEmpty()) {
            entity.set生活保護受給者(Boolean.TRUE);
        } else {
            entity.set生活保護受給者(Boolean.FALSE);
        }
        if (item.get識別コード_老齢福祉年金受給者() != null && !item.get識別コード_老齢福祉年金受給者().isEmpty()) {
            entity.set老齢福祉年金受給者(Boolean.TRUE);
        } else {
            entity.set老齢福祉年金受給者(Boolean.FALSE);
        }

        if (entity.get合計所得金額() == null) {
            entity.set合計所得金額(Decimal.ZERO);
        } else {
            entity.set合計所得金額(item.get合計所得金額());
        }

        if (entity.get年金収入額() == null) {
            entity.set年金収入額(Decimal.ZERO);
        } else {
            entity.set年金収入額(item.get年金収入額());
        }

        if (entity.get非課税年金勘案額() == null) {
            entity.set非課税年金勘案額(Decimal.ZERO);
        } else {
            entity.set非課税年金勘案額(item.get非課税年金勘案額());
        }

        if (isetai.get配偶者(isetai.get世帯員(item.get識別コード())) == null) {
            entity.set配偶者課税区分(RString.EMPTY);
            entity.set配偶者識別コード(ShikibetsuCode.EMPTY);
        } else {
            set識別コードValue(entity, item);
        }
        setis高齢者複数世帯(entity, item.get識別コード(), item.get基準日());
        if (entity.get課税所得額() == null) {
            entity.set課税所得額(Decimal.ZERO);
        } else {
            entity.set課税所得額(item.get課税所得額());
        }
    }

    private ISetai get世帯(ShikibetsuCode shikibetsuCode, FlexibleDate date) {
        return ShikibetsuTaishoService.getSetaiFinder().findBy識別コード(GyomuCode.DB介護保険, shikibetsuCode, date);
    }

    private void setis高齢者複数世帯(TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable, ShikibetsuCode shikibetsuCode, FlexibleDate date) {
        RString up年齢範囲 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        Range<Integer> 年齢範囲 = new Range(Integer.parseInt(up年齢範囲.toString()), Integer.parseInt("200"));
        if (!date.isEmpty() && 1 < get世帯(shikibetsuCode, date).get世帯員リスト(年齢範囲, new RDate(date.toString())).size()) {
            tempTable.set高齢者複数世帯(Boolean.TRUE);
        } else {
            tempTable.set高齢者複数世帯(Boolean.FALSE);
        }
    }

    private void set識別コードValue(TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable, TaishouJohoEntity list) {
        tempTable.set配偶者識別コード(iKojin.get識別コード());
        if (iKojin.get識別コード().equals(list.get識別コード())) {
            tempTable.set配偶者課税区分(list.get課税区分_住民税減免前());
        } else {
            tempTable.set配偶者課税区分(RString.EMPTY);
        }
    }
}
