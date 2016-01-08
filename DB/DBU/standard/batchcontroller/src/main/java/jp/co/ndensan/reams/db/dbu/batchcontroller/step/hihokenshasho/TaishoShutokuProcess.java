/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import java.util.ArrayList;
import java.util.List;
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
        List<IkkatsuHakkoRelateEntity> 対象情報List = 再発行チェック();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 対象情報List) {
            IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                    mybatisPrm.getKonkaiFromYMDHMS(),
                    mybatisPrm.getKonkaiToYMD(),
                    mybatisPrm.getKonkaiToYMDHMS(),
                    mybatisPrm.getKonkaikijunYMD(),
                    mybatisPrm.getKonkaikijunYMDHMS(),
                    mybatisPrm.getShinseishoKanriNo(),
                    mybatisPrm.getSeinengappiToYMD(),
                    mybatisPrm.getSeinengappiFromYMD(),
                    ikkatsuHakkoRelateEntity.getHihokenshaNo(),
                    mybatisPrm.getShikibetsuCode(),
                    mybatisPrm.getPsmShikibetsuTaisho(),
                    mybatisPrm.getPsmAtesaki(),
                    mybatisPrm.getNenreiTotatsuYMD());
            iIkkatsuHakkoMapper.deleteTmpHihoken(mybatisParam);
        }
    }

    private List<IkkatsuHakkoRelateEntity> 再発行チェック() {
        List<IkkatsuHakkoRelateEntity> 対象情報List = new ArrayList<>();
        switch (processPrm.getSaihakkoFlag().toString()) {
            case "0":
                対象情報List = 再発行チェックしない();
                break;
            case "1":
                対象情報List = 再発行チェックする();
                break;
            default:
                break;
        }
        return 対象情報List;
    }

    private List<IkkatsuHakkoRelateEntity> 再発行チェックしない() {

        //TODO 段站立　QA248　画面からの発行と一括発行の判定条件　2015/12/17から
        // 画面からの発行の場合、チェックしない。
        List<IkkatsuHakkoRelateEntity> 対象情報List = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 一括発行List = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 対象者取得List = 対象者取得();
        List<IkkatsuHakkoRelateEntity> 対象者1List = 対象者チェック1();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 対象者取得List) {
            IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                    mybatisPrm.getKonkaiFromYMDHMS(),
                    mybatisPrm.getKonkaiToYMD(),
                    mybatisPrm.getKonkaiToYMDHMS(),
                    mybatisPrm.getKonkaikijunYMD(),
                    mybatisPrm.getKonkaikijunYMDHMS(),
                    mybatisPrm.getShinseishoKanriNo(),
                    mybatisPrm.getSeinengappiToYMD(),
                    mybatisPrm.getSeinengappiFromYMD(),
                    ikkatsuHakkoRelateEntity.getHihokenshaNo(),
                    mybatisPrm.getShikibetsuCode(),
                    mybatisPrm.getPsmShikibetsuTaisho(),
                    mybatisPrm.getPsmAtesaki(),
                    mybatisPrm.getNenreiTotatsuYMD());
            一括発行List.addAll(iIkkatsuHakkoMapper.getIkkatsuShoriDateKanri(mybatisParam));
        }
        for (IkkatsuHakkoRelateEntity 対象者1Entity : 対象者1List) {
            for (IkkatsuHakkoRelateEntity 一括発行Entity1 : 一括発行List) {
                if (対象者1Entity.getHihokenshaNo().equals(一括発行Entity1.getHihokenshaNo())
                        && 対象者1Entity.getLastUpdateTimestamp().isAfter(一括発行Entity1.getHakkoShoriTimestamp().getRDateTime())) {
                    対象情報List.add(一括発行Entity1);
                }
            }
        }
        return 対象情報List;
    }

    private List<IkkatsuHakkoRelateEntity> 再発行チェックする() {
        List<IkkatsuHakkoRelateEntity> 再発行チェックする情報List = new ArrayList<>();
        IkkatsuHakkoMybatisParameter mybatisParam;
        List<IkkatsuHakkoRelateEntity> 対象者取得List = 対象者取得();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 対象者取得List) {
            mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                    mybatisPrm.getKonkaiFromYMDHMS(),
                    mybatisPrm.getKonkaiToYMD(),
                    mybatisPrm.getKonkaiToYMDHMS(),
                    mybatisPrm.getKonkaikijunYMD(),
                    mybatisPrm.getKonkaikijunYMDHMS(),
                    mybatisPrm.getShinseishoKanriNo(),
                    mybatisPrm.getSeinengappiToYMD(),
                    mybatisPrm.getSeinengappiFromYMD(),
                    ikkatsuHakkoRelateEntity.getHihokenshaNo(),
                    mybatisPrm.getShikibetsuCode(),
                    mybatisPrm.getPsmShikibetsuTaisho(),
                    mybatisPrm.getPsmAtesaki(),
                    mybatisPrm.getNenreiTotatsuYMD());
            再発行チェックする情報List.addAll(iIkkatsuHakkoMapper.getCheckShoriDateKanri(mybatisParam));
        }
        return 再発行チェックする情報List;
    }

    private List<IkkatsuHakkoRelateEntity> 対象者取得() {
        対象者チェック2();
        対象List.addAll(対象者チェック1());
        return 対象List;
    }

    private List<IkkatsuHakkoRelateEntity> 対象者チェック1() {
        return iIkkatsuHakkoMapper.getTaishoJoho1();
    }

    /**
     * TODO 段站立 QA296 チェック処理内容の確認　2015/12/23
     */
    private void 対象者チェック2() {
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

    private void check他市町村住所地特例(IkkatsuHakkoRelateEntity entity) {
        RString shikibetsuCode = entity.getShikibetsuCode().value();
        if (get最新他市町村住所地特例1().contains(shikibetsuCode)) {
            対象List.add(entity);
        } else if (get最新他市町村住所地特例2(entity).contains(shikibetsuCode)) {
            対象List.add(entity);
        }
    }

    private void check適用除外者(IkkatsuHakkoRelateEntity entity) {
        RString shikibetsuCode = entity.getShikibetsuCode().value();
        if (get適用除外者List1().contains(shikibetsuCode)) {
            check他市町村住所地特例(entity);
        } else if (get適用除外者List2(entity).contains(shikibetsuCode)) {
            check他市町村住所地特例(entity);
        }
    }

    private List<RString> get適用除外者List2(IkkatsuHakkoRelateEntity entity) {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 適用除外者List2 = iIkkatsuHakkoMapper.get最新適用除外者2(createPrm(entity));
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 適用除外者List2) {
            list.add(ikkatsuHakkoRelateEntity.getShikibetsuCode().value());
        }
        return list;
    }

    private List<RString> get最新他市町村住所地特例2(IkkatsuHakkoRelateEntity entity) {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 最新他市町村住所地特例List2 = iIkkatsuHakkoMapper.get最新他市町村住所地特例2(createPrm(entity));
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

    private IkkatsuHakkoMybatisParameter createPrm(IkkatsuHakkoRelateEntity entity) {
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

}
