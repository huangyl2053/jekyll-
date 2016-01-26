/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

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
 * 被保険者証一括発行_バッチフ処理クラスです
 */
public class TaishoShutokuProcess extends SimpleBatchProcessBase {

    private static final int NENREI_VALUE = 65;
    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;
    private List<IkkatsuHakkoRelateEntity> 対象List;

    @Override
    protected void beforeExecute() {
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        iIkkatsuHakkoMapper = getMapper(IIkkatsuHakkoMapper.class);
    }

    @Override
    protected void afterExecute() {

    }

    @Override
    protected void process() {
        if (iIkkatsuHakkoMapper.getTmpHihokenshasho_Ichi() > 0) {
            対象者チェック();
            再発行チェック();
            for (IkkatsuHakkoRelateEntity 対象Entity : 対象List) {
                iIkkatsuHakkoMapper.deleteTmpHihoken(createPrm被保険者番号(対象Entity));
            }
        }
    }

    private void 再発行チェック() {
        if (対象List != null) {
            switch (processPrm.getSaihakkoFlag().toString()) {
                case "0":
                    再発行チェックしない();
                    break;
                case "1":
                    再発行チェックする();
                    break;
                default:
                    break;
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
                    && 対象Entity.getLastUpdateTimestamp().isAfter(一括発行Map.get(hihokenshaNo).getLastUpdateTimestamp())) {
                対象List.remove(対象Entity);
            }
        }
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
                対象List.remove(対象Entity);
            }
        }
    }

    private void 対象者チェック() {
        対象List.addAll(iIkkatsuHakkoMapper.getTaishoJoho1());
        List<IkkatsuHakkoRelateEntity> 生年月日あるデータList = iIkkatsuHakkoMapper.get生年月日ある();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 生年月日あるデータList) {
            RString shikibetsuCode = ikkatsuHakkoRelateEntity.getShikibetsuCode().value();
            if (get被保険者List1().contains(shikibetsuCode)) {
                check適用除外者(ikkatsuHakkoRelateEntity);
            } else if (get被保険者List2().contains(shikibetsuCode)) {
                check適用除外者(ikkatsuHakkoRelateEntity);
            }
        }
    }

    private void check転入保留対象者(IkkatsuHakkoRelateEntity entity) {
        RString shikibetsuCode = entity.getShikibetsuCode().value();
        if (!get転入保留対象者().contains(shikibetsuCode)) {
            対象List.add(entity);
        }
    }

    private void check他市町村住所地特例(IkkatsuHakkoRelateEntity entity) {
        RString shikibetsuCode = entity.getShikibetsuCode().value();
        if (!get最新他市町村住所地特例1().contains(shikibetsuCode)) {
            check転入保留対象者(entity);
        } else if (get最新他市町村住所地特例2(entity).contains(shikibetsuCode)) {
            check転入保留対象者(entity);
        }
    }

    private void check適用除外者(IkkatsuHakkoRelateEntity entity) {
        RString shikibetsuCode = entity.getShikibetsuCode().value();
        if (!get適用除外者List1().contains(shikibetsuCode)) {
            check他市町村住所地特例(entity);
        } else if (get適用除外者List2(entity).contains(shikibetsuCode)) {
            check他市町村住所地特例(entity);
        }
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
                mybatisPrm.getShinseishoKanriNo(),
                mybatisPrm.getSeinengappiToYMD(),
                mybatisPrm.getSeinengappiFromYMD(),
                mybatisPrm.getHihokenshaNo(),
                mybatisPrm.getShikibetsuCode(),
                mybatisPrm.getPsmShikibetsuTaisho(),
                mybatisPrm.getPsmAtesaki(),
                ageCalculator.get年齢到達日(NENREI_VALUE));
        return mybatisParam;
    }

    private IkkatsuHakkoMybatisParameter createPrm被保険者番号(IkkatsuHakkoRelateEntity entity) {
        IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                mybatisPrm.getKonkaiFromYMDHMS(),
                mybatisPrm.getKonkaiToYMD(),
                mybatisPrm.getKonkaiToYMDHMS(),
                mybatisPrm.getKonkaikijunYMD(),
                mybatisPrm.getKonkaikijunYMDHMS(),
                mybatisPrm.getShinseishoKanriNo(),
                mybatisPrm.getSeinengappiToYMD(),
                mybatisPrm.getSeinengappiFromYMD(),
                entity.getHihokenshaNo(),
                mybatisPrm.getShikibetsuCode(),
                mybatisPrm.getPsmShikibetsuTaisho(),
                mybatisPrm.getPsmAtesaki(),
                mybatisPrm.getNenreiTotatsuYMD());
        return mybatisParam;
    }
}
