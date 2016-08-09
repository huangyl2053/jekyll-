/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmenGengakuTaishoShaHanteiYoukonSakusei;

import jp.co.ndensan.reams.db.dbd.definition.processprm.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter;
//import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenGengakuTaishoShaHanteiYoukonSakusei.TaishoShaHanteiYoukonkyoItokiTempTableEntity; TODO
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenGengakuTaishoShaHanteiYoukonSakusei.TaishouJohoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBTZ0001_減免減額対象者判定用根拠作成_process処理クラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
public class GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei extends BatchProcessBase<TaishouJohoEntity> {

    private static final RString MYBATIS_SELECT_ID_対象情報 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenGengakuTaishoShaHanteiYoukonSakusei.ITaishouJohoMapper.get対象情報");
    private GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter processParamter;
    private IKojin iKojin;
    private ISetai isetai;
    @BatchWriter
    BatchEntityCreatedTempTableWriter taishoShaHanteiYoukonkyoItokiTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_対象情報, processParamter.GemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
//        taishoShaHanteiYoukonkyoItokiTemp = new BatchEntityCreatedTempTableWriter(TaishoShaHanteiYoukonkyoItokiTempTableEntity.TABLE_NAME,
//                TaishoShaHanteiYoukonkyoItokiTempTableEntity.class);
    }

    @Override
    protected void process(TaishouJohoEntity list) {
//        TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable = new TaishoShaHanteiYoukonkyoItokiTempTableEntity();
//        setTaishouJohoEntityValues(list);
//        if (list.get課税区分_住民税減免前().equals(KazeiKubun.課税.getコード())) {
//            tempTable.set世帯課税区分(SetaiKazeiKubun.課税.getコード());
//        } else {
//            tempTable.set世帯課税区分(SetaiKazeiKubun.非課税.getコード());
//        }
//
//        if (list.get本人区分().equals(HonninKubun.本人.getCode())) {
//            if ((list.get識別コード_生活保護受給者() == null || list.get識別コード_生活保護受給者().isEmpty()) || (list.get識別コード_老齢福祉年金受給者().isEmpty() || list.get識別コード_老齢福祉年金受給者().isEmpty())) {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第一段階.getコード());
//            }
//            set減免減額対象者判定用根拠作成_本人(list, tempTable);
//            isetai = get世帯(list.get識別コード(), list.get基準日());
//            iKojin = get世帯(list.get識別コード(), list.get基準日()).get世帯員(list.get識別コード());
//            if (isetai.get配偶者(isetai.get世帯員(list.get識別コード())) == null) {
//                tempTable.set配偶者課税区分(RString.EMPTY);
//                tempTable.set配偶者識別コード(ShikibetsuCode.EMPTY);
//            } else {
//                tempTable.set配偶者識別コード(iKojin.get識別コード());
//                if (iKojin.get識別コード().equals(list.get識別コード())) {
//                    tempTable.set配偶者課税区分(list.get課税区分_住民税減免前());
//                } else {
//                    tempTable.set配偶者課税区分(RString.EMPTY);
//                }
//            }
//            setis高齢者複数世帯(tempTable, list.get識別コード(), list.get基準日());
//
//        } else {
//            if (list.get課税区分_住民税減免前().equals(KazeiKubun.課税.getコード())) {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第四段階.getコード());
//            } else if (!list.get本人区分().equals(HonninKubun.本人.getCode()) && ((list.get年金収入額().longValue() + list.get合計所得金額().longValue()) <= processParamter.getNumber().longValue())) {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第二段階.getコード());
//            } else {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第三段階.getコード());
//            }
//            set減免減額対象者判定用根拠作成_非私(list, tempTable);
//        }
//
//        if (list.get本人区分().equals(HonninKubun.本人.getCode())) {
//            if ((list.get識別コード_生活保護受給者() == null || list.get識別コード_生活保護受給者().isEmpty()) || (list.get識別コード_老齢福祉年金受給者().isEmpty() || list.get識別コード_老齢福祉年金受給者().isEmpty())) {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第一段階.getコード());
//            }
//            set減免減額対象者判定用根拠作成_本人(list, tempTable);
//            isetai = get世帯(list.get識別コード(), list.get基準日());
//            iKojin = get世帯(list.get識別コード(), list.get基準日()).get世帯員(list.get識別コード());
//            if (isetai.get配偶者(isetai.get世帯員(list.get識別コード())) == null) {
//                tempTable.set配偶者課税区分(RString.EMPTY);
//                tempTable.set配偶者識別コード(ShikibetsuCode.EMPTY);
//            } else {
//                tempTable.set配偶者識別コード(iKojin.get識別コード());
//                if (iKojin.get識別コード().equals(list.get識別コード())) {
//                    tempTable.set配偶者課税区分(list.get課税区分_住民税減免前());
//                } else {
//                    tempTable.set配偶者課税区分(RString.EMPTY);
//                }
//            }
//            setis高齢者複数世帯(tempTable, list.get識別コード(), list.get基準日());
//
//        } else {
//            if (list.get課税区分_住民税減免前().equals(KazeiKubun.課税.getコード())) {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第四段階.getコード());
//            } else if (!list.get本人区分().equals(HonninKubun.本人.getCode()) && ((list.get年金収入額().longValue() + list.get合計所得金額().longValue()) <= processParamter.getNumber().longValue())) {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第二段階.getコード());
//            } else {
//                tempTable.set利用者負担段階(RiyoshaFutanDankai.第三段階.getコード());
//            }
//            set減免減額対象者判定用根拠作成_非私(list, tempTable);
//        }
//
//        if (0 < list.get課税所得額().longValue()) {
//            tempTable.setIs所得税課税世帯(Boolean.TRUE);
//        } else {
//            tempTable.setIs所得税課税世帯(Boolean.FALSE);
//        }
//        taishoShaHanteiYoukonkyoItokiTemp.insert(tempTable);
    }

//    private void set減免減額対象者判定用根拠作成_本人(TaishouJohoEntity list, TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable) {
//        tempTable.set被保険者番号(list.get被保険者番号());
//        tempTable.set本人識別コード(list.get識別コード());
//        tempTable.set本人課税区分(list.get課税区分_住民税減免前());
//        if (list.get識別コード_生活保護受給者() != null || list.get識別コード_生活保護受給者().isEmpty()) {
//            tempTable.setIs生活保護受給者(Boolean.TRUE);
//        } else {
//            tempTable.setIs生活保護受給者(Boolean.FALSE);
//        }
//        if (list.get識別コード_老齢福祉年金受給者() != null || list.get識別コード_老齢福祉年金受給者().isEmpty()) {
//            tempTable.setIs老齢福祉年金受給者(Boolean.TRUE);
//        } else {
//            tempTable.setIs老齢福祉年金受給者(Boolean.FALSE);
//        }
//        tempTable.set合計所得金額(list.get合計所得金額());
//        tempTable.set年金収入額(list.get年金収入額());
//        tempTable.set非課税年金勘案額(list.get非課税年金勘案額());
//        if (0 < list.get課税所得額().longValue()) {
//            tempTable.setIs所得税課税者(Boolean.TRUE);
//        } else {
//            tempTable.setIs所得税課税者(Boolean.FALSE);
//        }
//    }
//
//    private void set減免減額対象者判定用根拠作成_非私(TaishouJohoEntity list, TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable) {
//        tempTable.set被保険者番号(HihokenshaNo.EMPTY);
//        tempTable.set本人識別コード(ShikibetsuCode.EMPTY);
//        tempTable.set本人課税区分(RString.EMPTY);
//        tempTable.setIs生活保護受給者(Boolean.TRUE);
//        tempTable.setIs老齢福祉年金受給者(Boolean.TRUE);
//        tempTable.set合計所得金額(Decimal.ZERO);
//        tempTable.set年金収入額(Decimal.ZERO);
//        tempTable.set非課税年金勘案額(Decimal.ZERO);
//        tempTable.setIs所得税課税者(Boolean.TRUE);
//        tempTable.set配偶者課税区分(RString.EMPTY);
//        tempTable.set配偶者識別コード(ShikibetsuCode.EMPTY);
//        tempTable.setIs高齢者複数世帯(Boolean.TRUE);
//    }
//
//    private ISetai get世帯(ShikibetsuCode shikibetsuCode, FlexibleDate date) {
//        ISetai isetai = ShikibetsuTaishoService.getSetaiFinder().findBy識別コード(GyomuCode.DB介護保険, shikibetsuCode, date);
//        return isetai;
//    }
//
//    private void setis高齢者複数世帯(TaishoShaHanteiYoukonkyoItokiTempTableEntity tempTable, ShikibetsuCode shikibetsuCode, FlexibleDate date) {
//        RString up年齢範囲 = DbBusinessConfig.get(ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
//        Range<Integer> 年齢範囲 = new Range(Integer.parseInt(up年齢範囲.toString()), Integer.parseInt("200"));
//        int size = get世帯(shikibetsuCode, date).get世帯員リスト(年齢範囲, new RDate(date.toString())).size();
//        if (1 < get世帯(shikibetsuCode, date).get世帯員リスト(年齢範囲, new RDate(date.toString())).size()) {
//            tempTable.setIs高齢者複数世帯(Boolean.TRUE);
//        } else {
//            tempTable.setIs高齢者複数世帯(Boolean.FALSE);
//        }
//    }
//
//    private void setTaishouJohoEntityValues(TaishouJohoEntity entity) {
//        if (entity.get課税区分_住民税減免前() == null || entity.get課税区分_住民税減免前().isEmpty()) {
//            entity.set課税区分_住民税減免前(RString.EMPTY);
//        }
//        if (entity.get合計所得金額() == null) {
//            entity.set合計所得金額(Decimal.ZERO);
//        }
//        if (entity.get基準日() == null || entity.get基準日().isEmpty()) {
//            entity.set基準日(FlexibleDate.EMPTY);
//        }
//        if (entity.get年金収入額() == null) {
//            entity.set年金収入額(Decimal.ZERO);
//        }
//        if (entity.get本人区分() == null || entity.get本人区分().isEmpty()) {
//            entity.set本人区分(RString.EMPTY);
//        }
//        if (entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()) {
//            entity.set被保険者番号(HihokenshaNo.EMPTY);
//        }
//        if (entity.get課税所得額() == null) {
//            entity.set課税所得額(Decimal.ZERO);
//        }
//        if (entity.get識別コード() == null || entity.get識別コード().isEmpty()) {
//            entity.set識別コード(ShikibetsuCode.EMPTY);
//        }
//        if (entity.get識別コード_生活保護受給者() == null || entity.get識別コード_生活保護受給者().isEmpty()) {
//            entity.set識別コード_生活保護受給者(ShikibetsuCode.EMPTY);
//        }
//        if (entity.get識別コード_老齢福祉年金受給者() == null || entity.get識別コード_老齢福祉年金受給者().isEmpty()) {
//            entity.set識別コード_老齢福祉年金受給者(ShikibetsuCode.EMPTY);
//        }
//        if (entity.get非課税年金勘案額() == null) {
//            entity.set非課税年金勘案額(Decimal.ZERO);
//        }
//
//    }
}
