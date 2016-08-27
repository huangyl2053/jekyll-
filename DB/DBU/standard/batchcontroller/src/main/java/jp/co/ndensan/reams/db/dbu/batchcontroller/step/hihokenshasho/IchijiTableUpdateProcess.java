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
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.SogoJigyoTaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証一括発行_バッチフ処理クラスです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
public class IchijiTableUpdateProcess extends SimpleBatchProcessBase {

    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;
    private List<IkkatsuHakkoRelateEntity> 一時表List;

    @Override
    protected void beforeExecute() {
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        iIkkatsuHakkoMapper = getMapper(IIkkatsuHakkoMapper.class);
        一時表List = iIkkatsuHakkoMapper.getTmpHihokenshasho_Ichi();
    }

    @Override
    protected void afterExecute() {
    }

    @Override
    protected void process() {
        if (一時表List != null && !一時表List.isEmpty()) {
            被保台帳を一時テーブルに更新();
            介護保険施設を一時テーブルに更新();
            受給者台帳を一時テーブルに更新();
            要介護認定を一時テーブルに更新();
            支払方法変更を一時テーブルに更新();
            居宅給付計画を一時テーブルに更新();
            本人情報を一時テーブルに更新();
            送付先情報を一時テーブルに更新();
            総合事業対象者情報を一時テーブルに更新();
        }
    }

    private void 被保台帳を一時テーブルに更新() {
        List<IkkatsuHakkoRelateEntity> 被保険者台帳List = iIkkatsuHakkoMapper.getHihokenshaDaicho();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 被保険者台帳List) {
            iIkkatsuHakkoMapper.updateTmp_Hihokenshasho(ikkatsuHakkoRelateEntity);
        }
    }

    private void 介護保険施設を一時テーブルに更新() {
        List<IkkatsuHakkoRelateEntity> 介護保険施設List = iIkkatsuHakkoMapper.getKaigoHokenShisetsuNyutaisho();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 介護保険施設List) {
            iIkkatsuHakkoMapper.updateTmp_KaigoHokenShisetsu(ikkatsuHakkoRelateEntity);
        }
    }

    private void 受給者台帳を一時テーブルに更新() {
        List<IkkatsuHakkoRelateEntity> 受給者台帳List = iIkkatsuHakkoMapper.getJukyushaDaicho();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 受給者台帳List) {
            iIkkatsuHakkoMapper.updateTmp_JukyushaDaicho(ikkatsuHakkoRelateEntity);
        }
    }

    private void 要介護認定を一時テーブルに更新() {
        List<IkkatsuHakkoRelateEntity> 要介護認定List = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 受給者台帳list = iIkkatsuHakkoMapper.getJukyushaDaicho();
        for (IkkatsuHakkoRelateEntity jukyushaDaichoEntity : 受給者台帳list) {
            IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                    mybatisPrm.getKonkaiFromYMDHMS(),
                    mybatisPrm.getKonkaiToYMD(),
                    mybatisPrm.getKonkaiToYMDHMS(),
                    mybatisPrm.getKonkaikijunYMD(),
                    mybatisPrm.getKonkaikijunYMDHMS(),
                    mybatisPrm.getKofuYMD(),
                    jukyushaDaichoEntity.getShinseishoKanriNo(),
                    mybatisPrm.getSeinengappiToYMD(),
                    mybatisPrm.getSeinengappiFromYMD(),
                    mybatisPrm.getHihokenshaNo(),
                    mybatisPrm.getShikibetsuCode(),
                    mybatisPrm.getPsmShikibetsuTaisho(),
                    mybatisPrm.getPsmAtesaki(),
                    mybatisPrm.getNenreiTotatsuYMD(),
                    RString.EMPTY);
            要介護認定List.addAll(iIkkatsuHakkoMapper.getNinteiKekkaJoho(mybatisParam));
        }
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 要介護認定List) {
            iIkkatsuHakkoMapper.updateTmp_NinteiKekkaJoho(ikkatsuHakkoRelateEntity);
        }
    }

    private void 支払方法変更を一時テーブルに更新() {
        List<IkkatsuHakkoRelateEntity> 支払方法変更List = iIkkatsuHakkoMapper.getShiharaiHohoHenko();
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 支払方法変更List) {
            iIkkatsuHakkoMapper.updateTmp_ShiharaiHohoHenko(ikkatsuHakkoRelateEntity);
        }
    }

    private void 居宅給付計画を一時テーブルに更新() {
        List<IkkatsuHakkoRelateEntity> 事業者作成List = iIkkatsuHakkoMapper.getKyotakuKeikakuJigyoshaSakusei();
        List<IkkatsuHakkoRelateEntity> 自己作成List = iIkkatsuHakkoMapper.getKyotakuKeikakuJikoSakusei();
        if (!事業者作成List.isEmpty() && 事業者作成List.get(0).getKeikakuJigyoshaNo() != null) {
            for (IkkatsuHakkoRelateEntity jigyoshaSakuseiEntity : 事業者作成List) {
                iIkkatsuHakkoMapper.updateTmp_Kyotaku(jigyoshaSakuseiEntity);
            }
        } else {
            for (IkkatsuHakkoRelateEntity jikoSakuseiEntity : 自己作成List) {
                iIkkatsuHakkoMapper.updateTmp_Kyotaku(jikoSakuseiEntity);
            }
        }
    }

    private void 総合事業対象者情報を一時テーブルに更新() {
        List<SogoJigyoTaishoshaRelateEntity> 総合事業対象者EntityList = iIkkatsuHakkoMapper.get総合事業対象者();
        for (SogoJigyoTaishoshaRelateEntity entity : 総合事業対象者EntityList) {
            iIkkatsuHakkoMapper.updateTmp総合事業対象者情報(entity);
        }
    }

    private void 本人情報を一時テーブルに更新() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        List<JuminShubetsu> juminShubetsu = new ArrayList<>();
        List<JuminJotai> juminJotai = new ArrayList<>();
        juminShubetsu.add(JuminShubetsu.日本人);
        juminShubetsu.add(JuminShubetsu.外国人);
        juminShubetsu.add(JuminShubetsu.住登外個人_外国人);
        juminShubetsu.add(JuminShubetsu.住登外個人_日本人);
        juminJotai.add(JuminJotai.住民);
        juminJotai.add(JuminJotai.住登外);
        juminJotai.add(JuminJotai.消除者);
        juminJotai.add(JuminJotai.転出者);
        key.set住民種別(juminShubetsu);
        key.set住民状態(juminJotai);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
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
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                mybatisPrm.getPsmAtesaki(),
                mybatisPrm.getNenreiTotatsuYMD(),
                RString.EMPTY);

        List<IkkatsuHakkoRelateEntity> 本人情報List = iIkkatsuHakkoMapper.getHonninJoho(mybatisParam);
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 本人情報List) {
            iIkkatsuHakkoMapper.updateTmp_HonninJoho(ikkatsuHakkoRelateEntity);
        }
    }

    private void 送付先情報を一時テーブルに更新() {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBU介護統計報告);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用しない);
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        builder.set基準日(FlexibleDate.getNowDate());
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(builder.build());
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
                new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()),
                mybatisPrm.getNenreiTotatsuYMD(),
                RString.EMPTY);
        List<IkkatsuHakkoRelateEntity> 送付先情報List = iIkkatsuHakkoMapper.getSofusakiJoho(mybatisParam);
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : 送付先情報List) {
            iIkkatsuHakkoMapper.updateTmp_SofusakiJoho(ikkatsuHakkoRelateEntity);
        }
    }
}
