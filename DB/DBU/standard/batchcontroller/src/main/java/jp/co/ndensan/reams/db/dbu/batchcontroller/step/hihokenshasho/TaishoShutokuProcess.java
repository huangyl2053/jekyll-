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

/**
 * 被保険者証一括発行_バッチフ処理クラスです
 */
public class TaishoShutokuProcess extends SimpleBatchProcessBase {

    private static final int NENREI_VALUE = 65;
    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;

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

    /**
     * 再発行した対象情報を取得します。
     *
     * @return 対象情報List
     */
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

    /**
     * 再発行チェックしない場合、対象情報を取得します。
     *
     * @return 対象情報List
     */
    private List<IkkatsuHakkoRelateEntity> 再発行チェックしない() {
        List<IkkatsuHakkoRelateEntity> 対象情報List = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 一括発行List = new ArrayList<>();
        IkkatsuHakkoMybatisParameter mybatisParam;
        List<IkkatsuHakkoRelateEntity> 対象者取得List = 対象者取得();
        List<IkkatsuHakkoRelateEntity> 対象者1List = 対象者チェック1();
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
            一括発行List.add((IkkatsuHakkoRelateEntity) iIkkatsuHakkoMapper.getIkkatsuShoriDateKanri(mybatisParam));
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

    /**
     * 再発行チェックする場合、対象情報を取得します。
     *
     * @return 再発行チェックする情報List
     */
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
            再発行チェックする情報List.add((IkkatsuHakkoRelateEntity) iIkkatsuHakkoMapper.getCheckShoriDateKanri(mybatisParam));
        }
        return 再発行チェックする情報List;
    }

    /**
     * すべての対象情報を取得します。
     *
     * @return 生年月日がない対象List
     */
    private List<IkkatsuHakkoRelateEntity> 対象者取得() {
        List<IkkatsuHakkoRelateEntity> 生年月日がない対象List = 対象者チェック1();
        List<IkkatsuHakkoRelateEntity> 生年月日がある対象List = 対象者チェック2();
        List<IkkatsuHakkoRelateEntity> 対象者List = new ArrayList<>();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 生年月日がない対象List) {
            生年月日がある対象List.add(ikkatsuHakkoRelateEntity);
            対象者List.add(ikkatsuHakkoRelateEntity);
        }
        return 対象者List;
    }

    /**
     * 生年月日の値がない場合、対象情報を取得します。
     *
     * @return 生年月日がない対象List
     */
    private List<IkkatsuHakkoRelateEntity> 対象者チェック1() {
        return iIkkatsuHakkoMapper.getTaishoJoho1();
    }

    /**
     * 生年月日の値がある場合、対象情報を取得します。
     *
     * @return 生年月日がある対象List
     */
    private List<IkkatsuHakkoRelateEntity> 対象者チェック2() {
        List<IkkatsuHakkoRelateEntity> 生年月日がある対象List = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 被保険者対象List = iIkkatsuHakkoMapper.check被保険者台帳管理();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 被保険者対象List) {
            AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory.createInstance(ikkatsuHakkoRelateEntity.getSeinengappiYMD()),
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
            List<IkkatsuHakkoRelateEntity> 適用除外者対象List = iIkkatsuHakkoMapper.check適用除外者(mybatisParam);
            生年月日がある対象List.add((IkkatsuHakkoRelateEntity) 適用除外者対象List);
        }
        return 生年月日がある対象List;
    }
}
