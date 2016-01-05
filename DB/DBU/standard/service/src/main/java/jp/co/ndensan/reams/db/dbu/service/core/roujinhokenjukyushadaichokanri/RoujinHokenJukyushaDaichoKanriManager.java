/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.roujinhokenjukyushadaichokanri;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.core.roujinhokenjukyushadaichokanri.RoujinHokenJukyushaDaichoKanriBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.roujinhokenjukyushadaichokanri.RoujinHokenJukyushaDaichoKanriMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7005RojinHokenJukyushaJohoDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老人保健受給者台帳管理するクラスです。
 *
 */
public class RoujinHokenJukyushaDaichoKanriManager {

    private final DbT7005RojinHokenJukyushaJohoDac dac;
    private final UaFt200FindShikibetsuTaishoFunctionDac uaFt200dac;

    /**
     * コンストラクタです。
     */
    public RoujinHokenJukyushaDaichoKanriManager() {
        dac = InstanceProvider.create(DbT7005RojinHokenJukyushaJohoDac.class);
        uaFt200dac = InstanceProvider.create(UaFt200FindShikibetsuTaishoFunctionDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7005RojinHokenJukyushaJohoDac}
     */
    RoujinHokenJukyushaDaichoKanriManager(DbT7005RojinHokenJukyushaJohoDac dac, UaFt200FindShikibetsuTaishoFunctionDac uaFt200dac) {
        this.dac = dac;
        this.uaFt200dac = uaFt200dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriMapperParameter}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriMapperParameter}のインスタンス
     */
    public static RoujinHokenJukyushaDaichoKanriManager createInstance() {
        return InstanceProvider.create(RoujinHokenJukyushaDaichoKanriManager.class);
    }

    /**
     * 老人保健受給者情報テーブルから老健受給情報老健受給情報を処理します。
     *
     * @param shikibetsuCode 識別コード
     * @return List<DbT7005RojinHokenJukyushaJohoEntity> 老健受給情報老健受給情報
     */
    @Transaction
    public List<RoujinHokenJukyushaDaichoKanriBusiness> getRoukenJukyuJoho(ShikibetsuCode shikibetsuCode) {
        List<RoujinHokenJukyushaDaichoKanriBusiness> buinessList = new ArrayList<>();
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        List<DbT7005RojinHokenJukyushaJohoEntity> entity = dac.selectRoukenJukyuJoho(shikibetsuCode);
        if (entity == null || entity.isEmpty()) {
            return new ArrayList();
        }
        for (DbT7005RojinHokenJukyushaJohoEntity entityList : entity) {
            buinessList.add(new RoujinHokenJukyushaDaichoKanriBusiness(entityList));
        }
        return buinessList;
    }

    /**
     * データあり場合、老健受給情報の更新処理を行うです 。
     *
     * @param shikibetsuCode 識別コード
     * @param rojinHokenShichosonCode 老人保健市町村コード
     * @param rojinHokenJukyushaNo 老人保健受給者番号
     * @return 更新件数を返却する。
     */
    @Transaction
    public int updateRoukenJukyuJoho(
            ShikibetsuCode shikibetsuCode,
            LasdecCode rojinHokenShichosonCode,
            RString rojinHokenJukyushaNo) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(rojinHokenShichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("老健受給者番号"));
        requireNonNull(rojinHokenJukyushaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("老健市町村番号"));
        RoujinHokenJukyushaDaichoKanriMapperParameter parameter
                = RoujinHokenJukyushaDaichoKanriMapperParameter.createParam_RoujinHoken(shikibetsuCode, null,
                        HihokenshaNo.EMPTY, rojinHokenShichosonCode, rojinHokenJukyushaNo);
        DbT7005RojinHokenJukyushaJohoEntity dbT7005entity = dac.selectByKey(shikibetsuCode);
        dbT7005entity.setShikibetsuCode(parameter.getShikibetsuCode());
        dbT7005entity.setRojinHokenShichosonCode(parameter.getRojinHokenShichosonCode());
        dbT7005entity.setRojinHokenJukyushaNo(parameter.getRojinHokenJukyushaNo());
        dbT7005entity.setState(EntityDataState.Modified);
        return dac.save(dbT7005entity);
    }

    /**
     * データなし場合、老健受給情報の登録処理を行うです 。
     *
     * @param shikibetsuCode 識別コード
     * @param shichosonCode 市町村コード
     * @param hihokenshaNo 被保険者番号
     * @param rojinHokenShichosonCode 老人保健市町村コード
     * @param rojinHokenJukyushaNo 老人保健受給者番号
     * @return 登録件数を返却する。
     */
    @Transaction
    public int insertRoukenJukyuJoho(
            ShikibetsuCode shikibetsuCode,
            LasdecCode shichosonCode,
            HihokenshaNo hihokenshaNo,
            LasdecCode rojinHokenShichosonCode,
            RString rojinHokenJukyushaNo) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(rojinHokenShichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健市町村コード"));
        requireNonNull(rojinHokenJukyushaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者番号"));
        this.select現全国地方公共団体コード();
        RoujinHokenJukyushaDaichoKanriMapperParameter parameter
                = RoujinHokenJukyushaDaichoKanriMapperParameter.createParam_RoujinHoken(shikibetsuCode,
                        shichosonCode, hihokenshaNo, rojinHokenShichosonCode, rojinHokenJukyushaNo);
        DbT7005RojinHokenJukyushaJohoEntity dbT7005entity = new DbT7005RojinHokenJukyushaJohoEntity();
        dbT7005entity.setShikibetsuCode(parameter.getShikibetsuCode());
        dbT7005entity.setShichosonCode(parameter.getShichosonCode());
        dbT7005entity.setHihokenshaNo(parameter.getHihokenshaNo());
        dbT7005entity.setRojinHokenShichosonCode(parameter.getRojinHokenShichosonCode());
        dbT7005entity.setRojinHokenJukyushaNo(parameter.getRojinHokenJukyushaNo());
        dbT7005entity.setState(EntityDataState.Added);
        return dac.save(dbT7005entity);
    }

    private void select現全国地方公共団体コード() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.UR業務共通, KensakuYusenKubun.住登外優先));
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(ShikibetsuCode.EMPTY);
        List<UaFt200FindShikibetsuTaishoEntity> entitylist = uaFt200dac.select(psm);
        for (UaFt200FindShikibetsuTaishoEntity entity : entitylist) {
            IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entity);
            shikibetsuTaisho.get現全国地方公共団体コード();
        }
    }
}
