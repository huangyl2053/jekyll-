package jp.co.ndensan.reams.db.dbu.service.core.basic.jyumikonyujyoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jyumikonyujyoho.JyuMiKoNyuJyoHoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jyumikonyujyoho.JyuMiKoNyuJyoHoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyumikonyujyoho.JyuMiKoNyuJyoHoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jyumikonyujyoho.IJyuMiKoNyuJyoHoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.SeikatsuHogoFujoShuruiCodeType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合照会_住民固有情報のFinderクラスです。
 *
 * @reamsid_L DBU-4100-060 houtianpeng
 */
public class JyuMiKoNyuJyoHoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7006RoreiFukushiNenkinJukyushaDac dbT7006dac;

    /**
     * コンストラクタです。
     */
    JyuMiKoNyuJyoHoFinder() {
        this.dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    JyuMiKoNyuJyoHoFinder(MapperProvider mapperProvider, DbT7006RoreiFukushiNenkinJukyushaDac dbT7006dac) {
        this.mapperProvider = mapperProvider;
        this.dbT7006dac = dbT7006dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JyuMiKoNyuJyoHoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JyuMiKoNyuJyoHoFinder}のインスタンス
     */
    public static JyuMiKoNyuJyoHoFinder createInstance() {
        return InstanceProvider.create(JyuMiKoNyuJyoHoFinder.class);
    }

    /**
     * 老齢福祉年金受給者情報の取得。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 老齢福祉年金受給者情報リスト
     */
    @Transaction
    public SearchResult<RoreiFukushiNenkinJukyusha> get老齢福祉年金受給者情報(HihokenshaNo 被保険者番号) {
        DbT7006RoreiFukushiNenkinJukyushaEntity entity = dbT7006dac.select老齢福祉年金受給者(被保険者番号);
        if (entity == null) {
            return SearchResult.of(Collections.<RoreiFukushiNenkinJukyusha>emptyList(), 0, false);
        }
        List<RoreiFukushiNenkinJukyusha> nenkinJukyushaList = new ArrayList();
        nenkinJukyushaList.add(new RoreiFukushiNenkinJukyusha(entity));
        return SearchResult.of(nenkinJukyushaList, 0, false);
    }

    /**
     * 生保受給者情報の取得。
     *
     * @param parameter JyuMiKoNyuJyoHoParameter
     * @return 生保受給者情報
     */
    @Transaction
    public SearchResult<JyuMiKoNyuJyoHoBusiness> get生保受給者情報の取得(JyuMiKoNyuJyoHoParameter parameter) {

        IJyuMiKoNyuJyoHoMapper jyuMiKoNyuJyoHoMapper = mapperProvider.create(IJyuMiKoNyuJyoHoMapper.class);
        JyuMiKoNyuJyoHoEntity jyuMiKoNyuJyoHo = jyuMiKoNyuJyoHoMapper.get生保受給者情報(parameter);
        if (jyuMiKoNyuJyoHo == null) {

            return SearchResult.of(Collections.<JyuMiKoNyuJyoHoBusiness>emptyList(), 0, false);
        }
        List<JyuMiKoNyuJyoHoBusiness> jyuMiKoNyuJyoHoList = new ArrayList();
        jyuMiKoNyuJyoHoList.add(new JyuMiKoNyuJyoHoBusiness(jyuMiKoNyuJyoHo));
        return SearchResult.of(jyuMiKoNyuJyoHoList, 0, false);
    }

    /**
     * 生保受給者情報の取得。
     *
     * @param parameter JyuMiKoNyuJyoHoParameter
     * @return 生保受給者情報
     */
    @Transaction
    public RString get生活保護扶助種類の取得(JyuMiKoNyuJyoHoParameter parameter) {
        IJyuMiKoNyuJyoHoMapper jyuMiKoNyuJyoHoMapper = mapperProvider.create(IJyuMiKoNyuJyoHoMapper.class);
        List<RString> 扶助種類コード = jyuMiKoNyuJyoHoMapper.get生活保護扶助種類(parameter);
        if (扶助種類コード == null) {
            return RString.EMPTY;
        }
        RStringBuilder 扶助種類 = new RStringBuilder();
        for (RString value : 扶助種類コード) {
            扶助種類.append(SeikatsuHogoFujoShuruiCodeType.toValue(value).toRString());
            扶助種類.append("/");
        }
        return 扶助種類.toRString().substring(0, 扶助種類.toRString().length() - 1);
    }

    /**
     * 生保受給者情報の取得。
     *
     * @param parameter JyuMiKoNyuJyoHoParameter
     * @return 生保受給者情報
     */
    @Transaction
    public SearchResult<JyuMiKoNyuJyoHoBusiness> get境界層管理情報取得(JyuMiKoNyuJyoHoParameter parameter) {

        IJyuMiKoNyuJyoHoMapper jyuMiKoNyuJyoHoMapper = mapperProvider.create(IJyuMiKoNyuJyoHoMapper.class);
        JyuMiKoNyuJyoHoEntity jyuMiKoNyuJyoHo = jyuMiKoNyuJyoHoMapper.get境界層管理情報取得(parameter);
        if (jyuMiKoNyuJyoHo == null) {
            return SearchResult.of(Collections.<JyuMiKoNyuJyoHoBusiness>emptyList(), 0, false);
        }
        List<JyuMiKoNyuJyoHoBusiness> jyuMiKoNyuJyoHoList = new ArrayList();
        jyuMiKoNyuJyoHoList.add(new JyuMiKoNyuJyoHoBusiness(jyuMiKoNyuJyoHo));
        return SearchResult.of(jyuMiKoNyuJyoHoList, 0, false);
    }
}
