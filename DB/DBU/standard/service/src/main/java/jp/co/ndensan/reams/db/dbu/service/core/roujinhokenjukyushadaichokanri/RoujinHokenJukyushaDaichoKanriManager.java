/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.roujinhokenjukyushadaichokanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.definition.roujinhokenjukyushadaichokanri.RoujinHokenJukyushaDaichoKanriParameter;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.roujinhokenjukyushadaichokanrimapper.IRoujinHokenJukyushaDaichoKanriMapper;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RojinHokenJukyushaJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7005RojinHokenJukyushaJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老人保健受給者情報管理するクラスです。
 *
 */
public class RoujinHokenJukyushaDaichoKanriManager {

    private final MapperProvider mapperProvider;
    private final DbT7005RojinHokenJukyushaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public RoujinHokenJukyushaDaichoKanriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7005RojinHokenJukyushaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7005RojinHokenJukyushaJohoDac}
     */
    RoujinHokenJukyushaDaichoKanriManager(MapperProvider mapperProvider, DbT7005RojinHokenJukyushaJohoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RoujinHokenJukyushaDaichoKanriManager}のインスタンス
     */
    public static RoujinHokenJukyushaDaichoKanriManager createInstance() {
        return InstanceProvider.create(RoujinHokenJukyushaDaichoKanriManager.class);
    }

    /**
     * 老人保健受給者情報テーブルから老健受給情報老健受給情報を取得します。
     *
     * @param shikibetsuCode 識別コード
     * @return RojinHokenJukyushaJoho 老健受給情報老健受給情報
     */
    @Transaction
    public RojinHokenJukyushaJoho getRoukenJukyuJoho(ShikibetsuCode shikibetsuCode) {
        DbT7005RojinHokenJukyushaJohoEntity entity = dac.selectRoukenJukyuJoho(shikibetsuCode);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        RojinHokenJukyushaJoho buinessList = new RojinHokenJukyushaJoho(entity);
        return buinessList;
    }

    /**
     * 老健受給情報{@link RojinHokenJukyushaJoho}を更新します。
     *
     * @param 老健受給情報 {@link RojinHokenJukyushaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int updateRoukenJukyuJoho(RojinHokenJukyushaJoho 老健受給情報) {
        requireNonNull(老健受給情報, UrSystemErrorMessages.値がnull.getReplacedMessage("老健受給情報"));
        if (!老健受給情報.hasChanged()) {
            return 0;
        }
        return dac.save(老健受給情報.toEntity());
    }

    /**
     * 老健受給情報{@link RojinHokenJukyushaJoho}を登録します。
     *
     * @param 老健受給情報 {@link RojinHokenJukyushaJoho}
     * @return 登録件数 登録結果の件数を返します。
     */
    @Transaction
    public int insertRoukenJukyuJoho(RojinHokenJukyushaJoho 老健受給情報) {
        requireNonNull(老健受給情報, UrSystemErrorMessages.値がnull.getReplacedMessage("老健受給情報"));
        if (!老健受給情報.hasChanged()) {
            return 0;
        }
        return dac.save(老健受給情報.toEntity());
    }

    /**
     * 宛名情報の現全国地方公共団体コードを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return 現全国地方公共団体コード
     */
    @Transaction
    public RString get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RoujinHokenJukyushaDaichoKanriParameter psmParameter = new RoujinHokenJukyushaDaichoKanriParameter(
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        IRoujinHokenJukyushaDaichoKanriMapper mapper = mapperProvider.create(IRoujinHokenJukyushaDaichoKanriMapper.class);
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = mapper.selectJyohou(psmParameter);
        RString genLasdecCode = ShikibetsuTaishoFactory.createKojin(宛名情報).get現全国地方公共団体コード().getColumnValue();
        return genLasdecCode;
    }
}
