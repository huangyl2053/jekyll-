/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU090010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証一括発行_バッチフ処理クラスです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public class TaishoShutokuProcess extends SimpleBatchProcessBase {

    private static final int NENREI_VALUE = 65;
    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;
    private List<IkkatsuHakkoRelateEntity> 一時表List;
    private List<IkkatsuHakkoRelateEntity> 対象List;
    private List<IkkatsuHakkoRelateEntity> check対象List;
    private List<IkkatsuHakkoRelateEntity> 対象外List;

    @Override
    protected void beforeExecute() {
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        iIkkatsuHakkoMapper = getMapper(IIkkatsuHakkoMapper.class);
        一時表List = iIkkatsuHakkoMapper.getTmpHihokenshasho_Ichi();
        対象List = new ArrayList<>();
        check対象List = new ArrayList<>();
        対象外List = new ArrayList<>();
    }

    @Override
    protected void afterExecute() {
        iIkkatsuHakkoMapper.updateJukyuKubun1(mybatisPrm);
        iIkkatsuHakkoMapper.updateJukyuKubun2(mybatisPrm);
    }

    @Override
    protected void process() {
        対象者チェック();
        再発行チェック();
        List<RString> list = new ArrayList<>();
        for (IkkatsuHakkoRelateEntity 対象Entity : 対象List) {
            list.add(対象Entity.getHihokenshaNo().value());
        }
        for (IkkatsuHakkoRelateEntity 一時表Entity : 一時表List) {
            if (!list.contains(一時表Entity.getHihokenshaNo().value())) {
                iIkkatsuHakkoMapper.deleteTmpHihoken(createPrm被保険者番号(一時表Entity));
            }
        }
    }

    private void 再発行チェック() {
        if (対象List != null) {
            if (processPrm.isSaihakkoFlag()) {
                再発行チェックする();
            } else {
                再発行チェックしない();
            }
        }
    }

    private void 再発行チェックしない() {
        List<IkkatsuHakkoRelateEntity> 一括発行List = new ArrayList<>();
        Map<RString, IkkatsuHakkoRelateEntity> 一括発行Map = new HashMap();
        for (IkkatsuHakkoRelateEntity entity : 対象List) {
            一括発行List.addAll(iIkkatsuHakkoMapper.getIkkatsuShoriDateKanri(createPrm被保険者番号(entity)));
        }
        for (IkkatsuHakkoRelateEntity 一括発行Entity : 一括発行List) {
            一括発行Map.put(一括発行Entity.getHihokenshaNo().value(), 一括発行Entity);
        }
        for (IkkatsuHakkoRelateEntity 対象Entity : 対象List) {
            RString hihokenshaNo = 対象Entity.getHihokenshaNo().value();
            if (対象Entity.getSeinengappiYMD() == null && 一括発行Map.containsKey(hihokenshaNo)
                    && 対象Entity.getLastUpdateTimestamp().isAfter(一括発行Map.get(hihokenshaNo).getHakkoShoriTimestamp().getRDateTime())) {
                対象外List.add(対象Entity);
            }
        }
        対象List.removeAll(対象外List);
    }

    private void 再発行チェックする() {
        List<IkkatsuHakkoRelateEntity> 再発行チェックList = new ArrayList<>();
        Map<RString, IkkatsuHakkoRelateEntity> 再発行チェックMap = new HashMap();
        for (IkkatsuHakkoRelateEntity entity : 対象List) {
            再発行チェックList.addAll(iIkkatsuHakkoMapper.getCheckShoriDateKanri(createPrm被保険者番号(entity)));
        }
        for (IkkatsuHakkoRelateEntity 再発行チェックEntity : 再発行チェックList) {
            再発行チェックMap.put(再発行チェックEntity.getHihokenshaNo().value(), 再発行チェックEntity);
        }
        for (IkkatsuHakkoRelateEntity 対象Entity : 対象List) {
            if (!再発行チェックMap.containsKey(対象Entity.getHihokenshaNo().value())) {
                対象外List.add(対象Entity);
            }
        }
        対象List.removeAll(対象外List);
    }

    private void 対象者チェック() {
        List<IkkatsuHakkoRelateEntity> 対象者チェック1 = iIkkatsuHakkoMapper.getTaishoJoho1();
        対象List.addAll(対象者チェック1);
        List<IkkatsuHakkoRelateEntity> 生年月日あるデータList = iIkkatsuHakkoMapper.get生年月日ある();
        List<RString> 被保険者List1 = get被保険者List1();
        List<RString> 被保険者List2 = get被保険者List2();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 生年月日あるデータList) {
            RString shikibetsuCode = ikkatsuHakkoRelateEntity.getShikibetsuCode().value();
            if (被保険者List1.contains(shikibetsuCode)) {
                check対象List.add(ikkatsuHakkoRelateEntity);
            } else if (!被保険者List2.contains(shikibetsuCode)) {
                check対象List.add(ikkatsuHakkoRelateEntity);
            }
        }
        check適用除外者(check対象List);
    }

    private void check転入保留対象者(List<IkkatsuHakkoRelateEntity> entityList) {
        for (IkkatsuHakkoRelateEntity entity : entityList) {
            RString shikibetsuCode = entity.getShikibetsuCode().value();
            if (get転入保留対象者().contains(shikibetsuCode)) {
                対象外List.add(entity);
            }
        }
        対象List.removeAll(対象外List);
        対象外List.clear();
    }

    private void check他市町村住所地特例(List<IkkatsuHakkoRelateEntity> entityList) {
        for (IkkatsuHakkoRelateEntity entity : entityList) {
            RString shikibetsuCode = entity.getShikibetsuCode().value();
            if (get最新他市町村住所地特例1().contains(shikibetsuCode)) {
                対象外List.add(entity);
            } else if (!get最新他市町村住所地特例2(entity).contains(shikibetsuCode)) {
                対象外List.add(entity);
            }
        }
        check対象List.removeAll(対象外List);
        対象外List.clear();
        check転入保留対象者(check対象List);
    }

    private void check適用除外者(List<IkkatsuHakkoRelateEntity> entityList) {
        for (IkkatsuHakkoRelateEntity entity : entityList) {
            RString shikibetsuCode = entity.getShikibetsuCode().value();
            if (get適用除外者List1().contains(shikibetsuCode)) {
                対象外List.add(entity);
            } else if (!get適用除外者List2(entity).contains(shikibetsuCode)) {
                対象外List.add(entity);
            }
        }
        check対象List.removeAll(対象外List);
        対象外List.clear();
        check他市町村住所地特例(check対象List);
    }

    private List<RString> get転入保留対象者() {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 転入保留対象者List = iIkkatsuHakkoMapper.get転入保留対象者();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 転入保留対象者List) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private List<RString> get適用除外者List2(IkkatsuHakkoRelateEntity entity) {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 適用除外者List2 = iIkkatsuHakkoMapper.get最新適用除外者2(createPrm年齢到達日(entity));
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 適用除外者List2) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private List<RString> get最新他市町村住所地特例2(IkkatsuHakkoRelateEntity entity) {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 最新他市町村住所地特例List2 = iIkkatsuHakkoMapper.get最新他市町村住所地特例2(createPrm年齢到達日(entity));
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 最新他市町村住所地特例List2) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private List<RString> get最新他市町村住所地特例1() {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 他市町村住所地特例List1 = iIkkatsuHakkoMapper.get最新他市町村住所地特例1();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 他市町村住所地特例List1) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private List<RString> get適用除外者List1() {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 適用除外者List1 = iIkkatsuHakkoMapper.get最新適用除外者1();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 適用除外者List1) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private List<RString> get被保険者List1() {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 被保険者List1 = iIkkatsuHakkoMapper.get最新被保険者1();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 被保険者List1) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private List<RString> get被保険者List2() {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 被保険者List2 = iIkkatsuHakkoMapper.get最新被保険者2();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 被保険者List2) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private IkkatsuHakkoMybatisParameter createPrm年齢到達日(IkkatsuHakkoRelateEntity entity) {
        AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory.createInstance(entity.getSeinengappiYMD()),
                JuminJotai.住民, FlexibleDate.MAX);
        IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                mybatisPrm.getKonkaiFromYMDHMS(),
                mybatisPrm.getKonkaiToYMD(),
                mybatisPrm.getKonkaiToYMDHMS(),
                mybatisPrm.getKonkaikijunYMD(),
                mybatisPrm.getKonkaikijunYMDHMS(),
                mybatisPrm.getKofuYMD(),
                mybatisPrm.getShinseishoKanriNo(),
                mybatisPrm.getSeinengappiToYMD(),
                mybatisPrm.getSeinengappiFromYMD(),
                mybatisPrm.getHihokenshaNo(),
                mybatisPrm.getShikibetsuCode(),
                mybatisPrm.getPsmShikibetsuTaisho(),
                mybatisPrm.getPsmAtesaki(),
                ageCalculator.get年齢到達日(NENREI_VALUE),
                RString.EMPTY);
        return mybatisParam;
    }

    private IkkatsuHakkoMybatisParameter createPrm被保険者番号(IkkatsuHakkoRelateEntity entity) {
        IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                mybatisPrm.getKonkaiFromYMDHMS(),
                mybatisPrm.getKonkaiToYMD(),
                mybatisPrm.getKonkaiToYMDHMS(),
                mybatisPrm.getKonkaikijunYMD(),
                mybatisPrm.getKonkaikijunYMDHMS(),
                mybatisPrm.getKofuYMD(),
                mybatisPrm.getShinseishoKanriNo(),
                mybatisPrm.getSeinengappiToYMD(),
                mybatisPrm.getSeinengappiFromYMD(),
                entity.getHihokenshaNo(),
                mybatisPrm.getShikibetsuCode(),
                mybatisPrm.getPsmShikibetsuTaisho(),
                mybatisPrm.getPsmAtesaki(),
                mybatisPrm.getNenreiTotatsuYMD(),
                RString.EMPTY);
        return mybatisParam;
    }
}
