/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.hihokenshasho;

import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hihokenshasho.IkkatsuHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hihokenshasho.IkkatsuHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho.IkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hihokenshasho.IIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時テーブルの作成_バッチフ処理クラスです。
 */
public class IchijiTableCreateProcess extends SimpleBatchProcessBase {

    private static final int NENREI_VALUE = 65;
    private IkkatsuHakkoProcessParameter processPrm;
    private IkkatsuHakkoMybatisParameter mybatisPrm;
    private IIkkatsuHakkoMapper iIkkatsuHakkoMapper;

    @Override
    protected void beforeExecute() {
        mybatisPrm = processPrm.toIkkatsuHakkoMybatisParameter();
        iIkkatsuHakkoMapper = getMapper(IIkkatsuHakkoMapper.class);
        iIkkatsuHakkoMapper.createTmpHihokenshasho_Ichi();
    }

    @Override
    protected void afterExecute() {

    }

    @Override
    protected void process() {
        List<IkkatsuHakkoRelateEntity> データ抽出list = データ抽出();
//        if (データ抽出list.isEmpty()) {
//            List<IkkatsuHakkoRelateEntity> 被保険者証一覧List = iIkkatsuHakkoMapper.getHihokenshaIchiran();
//            //TODO 内部：QA273　Redmine：#72186 被保険者証一覧表編集クラスが未実装
//        } else {
        for (IkkatsuHakkoRelateEntity ikkatsuHakkoRelateEntity : データ抽出list) {
            ikkatsuHakkoRelateEntity.setShisetyuJotaiFlag(FALSE);
            iIkkatsuHakkoMapper.insertTmpHihokenshasho_Ichi(ikkatsuHakkoRelateEntity);
        }
        iIkkatsuHakkoMapper.updateShisetyuJotaiFlag();
        //}
    }

    private List<IkkatsuHakkoRelateEntity> データ抽出() {
        List<IkkatsuHakkoRelateEntity> データ抽出list = new ArrayList<>();
        switch (processPrm.getShutsuryokuJokenCode().toString()) {
            case "2":
                データ抽出list = get受給者のみ();
                break;
            case "3":
                データ抽出list = get該当者全員();
                break;
            case "4":
                データ抽出list = get年齢到達予定者();
                break;
            default:
                break;
        }
        return データ抽出list;
    }

    private List<IkkatsuHakkoRelateEntity> get受給者のみ() {
        return iIkkatsuHakkoMapper.getJukyushaDaichoIdo(mybatisPrm);
    }

    private List<IkkatsuHakkoRelateEntity> get年齢到達予定者() {
        List<IkkatsuHakkoRelateEntity> nenreiTotatsuYoteshalist = new ArrayList<>();
        if (processPrm.getKonkaiKijunYMD().isBefore(processPrm.getKonkaiToYMD())) {
            ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                    createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
            List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
            key.setデータ取得区分(DataShutokuKubun.直近レコード);
            juminShubetsuList.add(JuminShubetsu.日本人);
            juminShubetsuList.add(JuminShubetsu.外国人);
            key.set住民種別(juminShubetsuList);
            List<JuminJotai> juminJotaiList = new ArrayList<>();
            juminJotaiList.add(JuminJotai.住民);
            key.set住民状態(juminJotaiList);
            UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
            IkkatsuHakkoMybatisParameter mybatisParam = IkkatsuHakkoMybatisParameter.createSelectByKeyParam(mybatisPrm.getShutsuryokuJokenCode(),
                    mybatisPrm.getKonkaiFromYMDHMS(),
                    mybatisPrm.getKonkaiToYMD(),
                    mybatisPrm.getKonkaiToYMDHMS(),
                    mybatisPrm.getKonkaikijunYMD(),
                    mybatisPrm.getKonkaikijunYMDHMS(),
                    mybatisPrm.getKofuYMD(),
                    mybatisPrm.getShinseishoKanriNo(),
                    mybatisPrm.getKonkaikijunYMD().plusDay(1).minusYear(NENREI_VALUE).plusDay(1),
                    mybatisPrm.getKonkaiToYMD().minusYear(NENREI_VALUE).plusDay(1),
                    mybatisPrm.getHihokenshaNo(),
                    mybatisPrm.getShikibetsuCode(),
                    new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                    mybatisPrm.getPsmAtesaki(),
                    mybatisPrm.getNenreiTotatsuYMD());
            List<IkkatsuHakkoRelateEntity> 年齢到達予定者List = iIkkatsuHakkoMapper.getNenreiTotatsuYotesha(mybatisParam);
            for (IkkatsuHakkoRelateEntity nenreiTotatsuYotesha : 年齢到達予定者List) {
                HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().
                        getHihokenshanotsukiban(nenreiTotatsuYotesha.getShikibetsuCode());
                nenreiTotatsuYotesha.setHihokenshaNo(hihokenshaNo);
                nenreiTotatsuYoteshalist.add(nenreiTotatsuYotesha);
            }
        }
        return nenreiTotatsuYoteshalist;
    }

    private List<IkkatsuHakkoRelateEntity> get該当者全員() {
        List<RString> list = new ArrayList<>();
        List<IkkatsuHakkoRelateEntity> 受給者台帳異動List = get受給者のみ();
        List<IkkatsuHakkoRelateEntity> 年齢到達予定者List = get年齢到達予定者();
        List<IkkatsuHakkoRelateEntity> 被保険者異動List = iIkkatsuHakkoMapper.getHihokenshaDaichoIdo(mybatisPrm);
        List<IkkatsuHakkoRelateEntity> 該当者全員List = new ArrayList<>();
        該当者全員List.addAll(年齢到達予定者List);
        for (IkkatsuHakkoRelateEntity 年齢到達予定者Entity : 年齢到達予定者List) {
            list.add(年齢到達予定者Entity.getHihokenshaNo().value());
        }
        Map<RString, IkkatsuHakkoRelateEntity> 受給者台帳異動Map = new HashMap();
        for (IkkatsuHakkoRelateEntity 受給者台帳異動Entity : 受給者台帳異動List) {
            if (!list.contains(受給者台帳異動Entity.getHihokenshaNo().value())) {
                受給者台帳異動Map.put(受給者台帳異動Entity.getHihokenshaNo().value(), 受給者台帳異動Entity);
            }
        }
        for (IkkatsuHakkoRelateEntity 被保険者異動Entiy : 被保険者異動List) {
            if (!list.contains(被保険者異動Entiy.getHihokenshaNo().value())) {
                get最新データ(受給者台帳異動Map, 被保険者異動Entiy);
            }
        }
        該当者全員List.addAll(受給者台帳異動Map.values());

        return 該当者全員List;
    }

    private void get最新データ(Map<RString, IkkatsuHakkoRelateEntity> 受給者台帳異動Map, IkkatsuHakkoRelateEntity 被保険者異動Entiy) {
        RString hihokenshaNo = 被保険者異動Entiy.getHihokenshaNo().value();
        if (受給者台帳異動Map.containsKey(hihokenshaNo)) {
            IkkatsuHakkoRelateEntity 受給者台帳異動Entity = 受給者台帳異動Map.get(hihokenshaNo);
            if (受給者台帳異動Entity.getInsertTimestamp().isBefore(被保険者異動Entiy.getInsertTimestamp())) {
                受給者台帳異動Map.put(被保険者異動Entiy.getHihokenshaNo().value(), 被保険者異動Entiy);
            }
        } else {
            受給者台帳異動Map.put(被保険者異動Entiy.getHihokenshaNo().value(), 被保険者異動Entiy);
        }

    }
}
