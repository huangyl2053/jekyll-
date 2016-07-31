/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shakaifukushihojinkeigen;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen.GemmenKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.shakaifukushihojinkeigen.IShakaiFukushiHojinKeigenMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 社会福祉法人等利用者負担軽減申請（画面）です。
 *
 * @reamsid_L DBD-3660-030 wangjie2
 */
public class ShakaiFukushiHojinKeigenService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShakaiFukushiHojinKeigenService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 社会福祉法人等利用者負担軽減申請（画面）のIntanceを作成します。
     *
     * @return ShakaiFukushiHojinKeigenService
     */
    public static ShakaiFukushiHojinKeigenService createIntance() {
        return InstanceProvider.create(ShakaiFukushiHojinKeigenService.class);
    }

    /**
     * 社会福祉法人等利用者負担軽減情報の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List< 社会福祉法人等利用者負担軽減の情報>
     */
    @Transaction
    public List<ShakaifukuRiyoshaFutanKeigen> load社会福祉法人等利用者負担軽減申請All(HihokenshaNo 被保険者番号) {
        List<ShakaifukuRiyoshaFutanKeigen> 社会福祉法人等利用者負担軽減の情報List = new ArrayList<>();
        ShakaiFukushiHojinKeigenParameter 検索条件 = new ShakaiFukushiHojinKeigenParameter(
                被保険者番号, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード());
        IShakaiFukushiHojinKeigenMapper mapper = mapperProvider.create(IShakaiFukushiHojinKeigenMapper.class);
        List<ShafukuRiyoshaFutanKeigenEntity> entityList = mapper.get社会福祉法人等利用者負担軽減の情報List(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (ShafukuRiyoshaFutanKeigenEntity entity : entityList) {
                社会福祉法人等利用者負担軽減の情報List.add(new ShakaifukuRiyoshaFutanKeigen(entity));
            }
        }
        return 社会福祉法人等利用者負担軽減の情報List;
    }

    /**
     * 標準有効期限判定します。
     *
     * @param 適用日 適用日
     * @return 有効期限
     */
    public FlexibleDate estimate有効期限(FlexibleDate 適用日) {
        if (null == 適用日 || 適用日.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        RString 有効期限RString;
        if (適用日.isBeforeOrEquals(new FlexibleDate(new RString("20050930")))) {
            有効期限RString = DbBusinessConfig.get(ConfigNameDBD.減免期限_法人減免,
                    new RDate(適用日.getYearValue(), 適用日.getMonthValue(), 適用日.getDayValue()), SubGyomuCode.DBD介護受給);
        } else {
            有効期限RString = DbBusinessConfig.get(ConfigNameDBD.減免期限_法人軽減,
                    new RDate(適用日.getYearValue(), 適用日.getMonthValue(), 適用日.getDayValue()), SubGyomuCode.DBD介護受給);
        }
        if (有効期限RString.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        FlexibleDate 有効期限候補 = new FlexibleDate(new RString(String.valueOf(適用日.getYearValue())).concat(有効期限RString));
        if (適用日.isBeforeOrEquals(有効期限候補)) {
            return 有効期限候補;
        } else {
            return 有効期限候補.plusYear(1);
        }
    }

    /**
     * 年度内の確認番号の重複判定します。
     *
     * @param 確認番号 確認番号
     * @param 適用日 適用日
     * @return 年度内の確認番号の重複
     * @throws NullPointerException　入力のいずれかがnullの場合、NullPointerExceptionをスローする。
     */
    public boolean exsits確認番号In同一年度(RString 確認番号, FlexibleDate 適用日) {
        requireNonNull(確認番号, UrSystemErrorMessages.値がnull.getReplacedMessage("確認番号"));
        requireNonNull(適用日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用日"));
        FlexibleDate 年度終了日 = estimate有効期限(適用日);
        FlexibleDate 年度終了日の前年;
        if (年度終了日.isEmpty()) {
            年度終了日の前年 = FlexibleDate.EMPTY;
        } else {
            年度終了日の前年 = new FlexibleDate(年度終了日.getYearValue() - 1, 1, 1);
        }
        FlexibleDate 年度開始日;
        if (年度終了日の前年.isEmpty()) {
            年度開始日 = FlexibleDate.EMPTY;
        } else {
            年度開始日 = estimate有効期限(年度終了日の前年).plusDay(1);
        }
        DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac dac
                = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
        List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> entityList
                = dac.selectFor年度内の確認番号の重複判定(年度開始日, 年度終了日, 確認番号);
        return entityList != null && !entityList.isEmpty();
    }

    /**
     * 利用者の判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 適用日 適用日
     * @return 減免の利用者になれるかどうか
     */
    public boolean canBe利用者(HihokenshaNo 被保険者番号, FlexibleDate 適用日) {
        DbT4001JukyushaDaichoDac dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        List<DbT4001JukyushaDaichoEntity> dbT4001EntityList = dac.selectfor受給者の判定(被保険者番号, 適用日, YukoMukoKubun.無効.getコード());
        return dbT4001EntityList != null && !dbT4001EntityList.isEmpty();
    }

    /**
     * 減免区分の初期値判定します。
     *
     * @param 識別コード 識別コード
     * @param 適用日 適用日
     * @return 減免区分
     */
    public GemmenKubun find減免区分初期値(ShikibetsuCode 識別コード, FlexibleDate 適用日) {
        DbT7006RoreiFukushiNenkinJukyushaDac dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006EntityList = dac.selectfor老齢福祉年金受給者の判定(識別コード, 適用日);
        if (dbT7006EntityList != null && !dbT7006EntityList.isEmpty()) {
            return GemmenKubun.非課税_老年受給;
        }
        SetaiinShotokuJohoFinder setaiinShotokuJohoFinder = SetaiinShotokuJohoFinder.createInstance();
        FlexibleYear 所得年度 = FlexibleYear.EMPTY;
        if (適用日 != null && !適用日.isEmpty()) {
            所得年度 = 適用日.getYear();
        }
        List<SetaiinShotoku> 世帯員所得情報List = setaiinShotokuJohoFinder.get世帯員所得情報(識別コード, 所得年度, null);
        for (SetaiinShotoku 世帯員所得情報 : 世帯員所得情報List) {
            if (識別コード.equals(世帯員所得情報.get識別コード())
                    && !KazeiKubun.課税.getコード().equals(世帯員所得情報.get課税区分_住民税減免前())) {
                return GemmenKubun.非課税_老年受給;
            }
        }
        if (SeikatsuhogoManagerFactory.createInstance().get生活保護(識別コード, GyomuCode.DB介護保険, 適用日) != null) {
            return GemmenKubun.生保に準ずる;
        }
        return GemmenKubun.その他;
    }

}
