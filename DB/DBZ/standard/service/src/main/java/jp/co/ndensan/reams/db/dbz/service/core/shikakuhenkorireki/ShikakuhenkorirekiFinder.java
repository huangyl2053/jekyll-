/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shikakuhenkorireki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.TextSearchType;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 対象者個人情報取得
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class ShikakuhenkorirekiFinder {

    private final DbT1001HihokenshaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    ShikakuhenkorirekiFinder() {
        dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SikakuIdoCheckManager}のインスタンスを返します。
     *
     * @return SikakuIdoCheckManager
     *
     */
    public static ShikakuhenkorirekiFinder createInstance() {
        return InstanceProvider.create(ShikakuhenkorirekiFinder.class);

    }

    /**
     * 対象者個人情報取得(識別コード経由)
     *
     * @param 処理対象者 IKojin
     * @return 個人情報
     */
    public List<IKojin> getKojinInfoByShikibetuCd(IKojin 処理対象者) {
        List<JuminShubetsu> 住民種別list = new ArrayList<>();
        住民種別list.add(JuminShubetsu.日本人);
        住民種別list.add(JuminShubetsu.外国人);
        住民種別list.add(JuminShubetsu.住登外個人_日本人);
        住民種別list.add(JuminShubetsu.住登外個人_外国人);

        List<JuminJotai> 住民状態list = new ArrayList<>();
        住民状態list.add(JuminJotai.住民);
        住民状態list.add(JuminJotai.住登外);
        住民状態list.add(JuminJotai.消除者);
        住民状態list.add(JuminJotai.転出者);
        住民状態list.add(JuminJotai.死亡者);

        IShikibetsuTaishoGyomuHanteiKey 業務判定キー = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先);
        IShikibetsuTaishoSearchKey 検索キー
                = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー, true)
                .set氏名検索方法(TextSearchType.部分一致)
                .set氏名(処理対象者.get名称().getKana().value())
                .set性別(処理対象者.get性別())
                .set生年月日(処理対象者.get生年月日().toFlexibleDate())
                .set住民種別(住民種別list)
                .set住民状態(住民状態list)
                .build();
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(検索キー);

        List<UaFt200FindShikibetsuTaishoEntity> 対象者個人情報 = InstanceProvider.create(
                UaFt200FindShikibetsuTaishoFunctionDac.class).select(psm);
        if (対象者個人情報.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<IKojin> kojins = new ArrayList<>();
            for (UaFt200FindShikibetsuTaishoEntity entity : 対象者個人情報) {
                kojins.add(ShikibetsuTaishoFactory.createKojin(entity));
            }
            return kojins;
        }
    }

    /**
     * 被保険者台帳管理テーブルから、処理対象者の被保険者番号を元に、最新履歴を取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @return HihokenshaDaicho
     */
    public HihokenshaDaicho getHihokenshaDaichoByHihokenshaNo(HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity entity = dac.selectByHihokensha(被保険者番号);
        if (entity != null) {
            return new HihokenshaDaicho(entity);
        }
        return null;
    }
}
