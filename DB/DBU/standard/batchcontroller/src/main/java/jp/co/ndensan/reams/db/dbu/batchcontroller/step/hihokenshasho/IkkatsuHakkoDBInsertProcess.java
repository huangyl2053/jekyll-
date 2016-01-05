/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import static java.lang.Boolean.FALSE;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 被保険者証一括発行_バッチフ処理クラスです
 */
public class IkkatsuHakkoDBInsertProcess extends SimpleBatchProcessBase {

    private static final RString KOFUSHOSHURUI_VALUE = new RString("001");
    private static final RString KOFUJIYU_CODE1 = new RString("01");
    private static final RString KOFURIYU_VALUE1 = new RString("資格取得");
    private static final RString KOFUJIYU_CODE2 = new RString("02");
    private static final RString KOFURIYU_VALUE2 = new RString("要介護認定");
    private static final RString SHINYOSHIKISUMIKUBUN_CODE = new RString("01");
    private static final RString SHOYOSHIKIKUBUN_CODE = new RString("02");
    private static final boolean TANPYOHAKKOUMUFLAG = FALSE;
    private static final boolean LOGICALDELETEDFLAG = FALSE;
    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;
    private List<IkkatsuHakkoRelateEntity> 被保険者証一覧リスト;
    private RString kofuJiyu;
    private RString kofuRiyu;

    @Override
    protected void beforeExecute() {
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        iIkkatsuHakkoMapper = getMapper(IIkkatsuHakkoMapper.class);
        被保険者証一覧リスト = iIkkatsuHakkoMapper.getHihokenshaIchiran();
    }

    @Override
    protected void afterExecute() {
        iIkkatsuHakkoMapper.dropTmpHihokenshasho_Ichi();
    }

    @Override
    protected void process() {
        if (processPrm.getTestShutsuryokuFlag().toString().equals("0")) {
            for (IkkatsuHakkoRelateEntity entity : 被保険者証一覧リスト) {
                iIkkatsuHakkoMapper.insertShoKofuKaishu(set証交付回収Entity(entity));
            }
            iIkkatsuHakkoMapper.updateShoriDateKanri(mybatisPrm);
        }
    }

    /**
     * DbT7037ShoKofuKaishuEntityの設定です。
     *
     * @param IkkatsuHakkoRelateEntity entity
     * @return DbT7037ShoKofuKaishuEntity dbT7037Entity
     */
    private DbT7037ShoKofuKaishuEntity set証交付回収Entity(IkkatsuHakkoRelateEntity entity) {
        DbT7037ShoKofuKaishuEntity dbT7037Entity = new DbT7037ShoKofuKaishuEntity();
        get交付情報(entity);
        dbT7037Entity.setHihokenshaNo(entity.getHihokenshaNo());
        dbT7037Entity.setKofuShoShurui(KOFUSHOSHURUI_VALUE);
        dbT7037Entity.setRirekiNo(get最大履歴番号(entity.getHihokenshaNo()));
        dbT7037Entity.setShichosonCode(entity.getShichosonCode());
        dbT7037Entity.setShikibetsuCode(entity.getShikibetsuCode());
        dbT7037Entity.setKofuYMD(processPrm.getKofuYMD());
        dbT7037Entity.setYukoKigenYMD(FlexibleDate.EMPTY);
        dbT7037Entity.setKofuJiyu(kofuJiyu);
        dbT7037Entity.setKofuRiyu(kofuRiyu);
        dbT7037Entity.setKaishuYMD(FlexibleDate.EMPTY);
        dbT7037Entity.setKaishuJiyu(RString.EMPTY);
        dbT7037Entity.setKaishuRiyu(RString.EMPTY);
        dbT7037Entity.setTanpyoHakkoUmuFlag(TANPYOHAKKOUMUFLAG);
        dbT7037Entity.setHakkoShoriTimestamp(YMDHMS.now());
        dbT7037Entity.setShinYoshikiSumiKubunCode(SHINYOSHIKISUMIKUBUN_CODE);
        dbT7037Entity.setShoYoshikiKubunCode(SHOYOSHIKIKUBUN_CODE);
        dbT7037Entity.setLogicalDeletedFlag(LOGICALDELETEDFLAG);
        return dbT7037Entity;
    }

    /**
     * 交付事由と交付理由を取得します。
     *
     * @param IkkatsuHakkoRelateEntity entity
     */
    private void get交付情報(IkkatsuHakkoRelateEntity entity) {
        set証交付回収Entity(entity);
        switch (processPrm.getShutsuryokuJokenCode().toString()) {
            case "2":
                kofuJiyu = KOFUJIYU_CODE2;
                kofuRiyu = KOFURIYU_VALUE2;
                break;
            case "3":
                UzT0007CodeEntity codeMastEntity;
                codeMastEntity = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0002"), new Code(entity.getIdoJiyuCode()));
                kofuJiyu = codeMastEntity.getコード().value();
                kofuRiyu = codeMastEntity.getコード名称();
                break;
            case "4":
                kofuJiyu = KOFUJIYU_CODE1;
                kofuRiyu = KOFURIYU_VALUE1;
                break;
            default:
                break;
        }
    }

    /**
     * 同一被保険者番号の最大履歴番号を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return rirekiNo 履歴番号
     */
    private int get最大履歴番号(HihokenshaNo hihokenshaNo) {
        IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                mybatisPrm.getKonkaiFromYMDHMS(),
                mybatisPrm.getKonkaiToYMD(),
                mybatisPrm.getKonkaiToYMDHMS(),
                mybatisPrm.getKonkaikijunYMD(),
                mybatisPrm.getKonkaikijunYMDHMS(),
                mybatisPrm.getShinseishoKanriNo(),
                mybatisPrm.getSeinengappiToYMD(),
                mybatisPrm.getSeinengappiFromYMD(),
                hihokenshaNo,
                mybatisPrm.getShikibetsuCode(),
                mybatisPrm.getPsmShikibetsuTaisho(),
                mybatisPrm.getPsmAtesaki(),
                mybatisPrm.getNenreiTotatsuYMD());
        return iIkkatsuHakkoMapper.getSaishinrirekiNo(mybatisParam).getRirekiNo();
    }
}
