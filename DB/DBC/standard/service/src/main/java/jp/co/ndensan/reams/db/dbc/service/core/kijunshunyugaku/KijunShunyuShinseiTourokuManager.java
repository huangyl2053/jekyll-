/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kijunshunyugaku;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KijunShunyugakuTekiyoKanri;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3116KijunShunyugakuTekiyoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunshunyugaku.IKijunShunyuShinseiTourokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 基準収入額適用申請登録のビジネスクラスです。
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class KijunShunyuShinseiTourokuManager {

    private final MapperProvider mapperProvider;
    private final DbT3116KijunShunyugakuTekiyoKanriDac dbT3116Dac;
    private final DbT3105SogoJigyoTaishoshaDac dbT3105Dac;
    private final DbT4001JukyushaDaichoDac dbT4001Dac;
    private static final RString STR_ONE = new RString("1");
    private static final RString STR_履歴番号 = new RString("0000");

    /**
     * コンストラクタです。
     */
    public KijunShunyuShinseiTourokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT3116Dac = InstanceProvider.create(DbT3116KijunShunyugakuTekiyoKanriDac.class);
        this.dbT3105Dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
        this.dbT4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KijunShunyuShinseiTourokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KijunShunyuShinseiTourokuManager}のインスタンス
     */
    public static KijunShunyuShinseiTourokuManager createInstance() {
        return InstanceProvider.create(KijunShunyuShinseiTourokuManager.class);
    }

    /**
     * 被保険者番号に一致する最新のレコードを取得のメソッドです。
     *
     * @param parameter Map
     * @return 被保険者台帳管理
     */
    public HihokenshaDaicho get被保険者台帳(Map<String, Object> parameter) {
        IKijunShunyuShinseiTourokuMapper mapper = mapperProvider.create(IKijunShunyuShinseiTourokuMapper.class);
        DbT1001HihokenshaDaichoEntity 被保険者台帳Entity = mapper.get被保険者台帳(parameter);
        if (被保険者台帳Entity == null) {
            return null;
        }
        被保険者台帳Entity.initializeMd5();
        return new HihokenshaDaicho(被保険者台帳Entity);
    }

    /**
     * 基準収入額適用管理情報を取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 世帯コード SetaiCode
     * @return 基準収入額適用管理情報
     */
    public List<KijunShunyugakuTekiyoKanri> get基準収入額適用管理情報(HihokenshaNo 被保険者番号, SetaiCode 世帯コード) {
        List<KijunShunyugakuTekiyoKanri> 基準収入額適用管理情報List = new ArrayList<>();
        List<DbT3116KijunShunyugakuTekiyoKanriEntity> 管理情報List = dbT3116Dac.select基準収入額適用管理情報(
                被保険者番号, 世帯コード);
        if (管理情報List == null || 管理情報List.isEmpty()) {
            return 基準収入額適用管理情報List;
        }
        for (DbT3116KijunShunyugakuTekiyoKanriEntity entity : 管理情報List) {
            entity.initializeMd5();
            基準収入額適用管理情報List.add(new KijunShunyugakuTekiyoKanri(entity));
        }
        return 基準収入額適用管理情報List;
    }

    /**
     * 基準収入額適用管理情報を取得のメソッドです。
     *
     * @param 世帯コード SetaiCode
     * @param 年度 FlexibleYear
     * @param 履歴番号 int
     * @return 基準収入額適用管理情報
     */
    public List<KijunShunyugakuTekiyoKanri> get基準収入額適用管理情報BY世帯コード(SetaiCode 世帯コード,
            FlexibleYear 年度,
            int 履歴番号) {
        List<KijunShunyugakuTekiyoKanri> 基準収入額適用管理情報List = new ArrayList<>();
        List<DbT3116KijunShunyugakuTekiyoKanriEntity> 管理情報List = dbT3116Dac.select基準収入額適用管理情報BY世帯コード(
                世帯コード, 年度, 履歴番号);
        if (管理情報List == null || 管理情報List.isEmpty()) {
            return 基準収入額適用管理情報List;
        }
        for (DbT3116KijunShunyugakuTekiyoKanriEntity entity : 管理情報List) {
            entity.initializeMd5();
            基準収入額適用管理情報List.add(new KijunShunyugakuTekiyoKanri(entity));
        }
        return 基準収入額適用管理情報List;
    }

    /**
     * 受給の取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 世帯基準日 FlexibleDate
     * @param 被保険者番号Flag boolean
     * @return 受給者台帳カウント
     */
    public int get受給(HihokenshaNo 被保険者番号, FlexibleDate 世帯基準日, boolean 被保険者番号Flag) {
        List<DbT4001JukyushaDaichoEntity> 受給者台帳List = dbT4001Dac.get受給(被保険者番号,
                世帯基準日, STR_ONE, STR_履歴番号, 被保険者番号Flag);
        if (受給者台帳List == null || 受給者台帳List.isEmpty()) {
            return 0;
        } else {
            return 受給者台帳List.size();
        }
    }

    /**
     * 事業対象取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 世帯基準日 FlexibleDate
     * @return 事業対象者カウント
     */
    public int get事業対象(HihokenshaNo 被保険者番号, FlexibleDate 世帯基準日) {
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者管理List = dbT3105Dac.get事業対象(被保険者番号, 世帯基準日);
        if (総合事業対象者管理List == null || 総合事業対象者管理List.isEmpty()) {
            return 0;
        } else {
            return 総合事業対象者管理List.size();
        }
    }

    /**
     * 適用開始チェックのメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 適用開始年月 FlexibleYearMonth
     * @return boolean
     */
    public boolean is適用開始チェック(HihokenshaNo 被保険者番号, FlexibleYearMonth 適用開始年月) {
        List<DbT3116KijunShunyugakuTekiyoKanriEntity> 基準収入額適用管理List = dbT3116Dac.selectBy適用開始年月(
                被保険者番号, 適用開始年月);
        return (基準収入額適用管理List == null || 基準収入額適用管理List.isEmpty());
    }

    /**
     * 基準収入額適用管理マスタに登録のメソッドです。
     *
     * @param 追加データList List
     * @param 修正データList List
     * @param 削除データList List
     */
    @Transaction
    public void 保存基準収入額適用管理情報(List<KijunShunyugakuTekiyoKanri> 追加データList,
            List<KijunShunyugakuTekiyoKanri> 修正データList,
            List<KijunShunyugakuTekiyoKanri> 削除データList) {

        if (!追加データList.isEmpty()) {
            for (KijunShunyugakuTekiyoKanri 追加データ : 追加データList) {
                DbT3116KijunShunyugakuTekiyoKanriEntity entity = 追加データ.toEntity();
                entity.setState(EntityDataState.Added);
                dbT3116Dac.saveOrDeletePhysicalBy(entity);
            }
        }
        if (!修正データList.isEmpty()) {
            for (KijunShunyugakuTekiyoKanri 修正データ : 修正データList) {
                DbT3116KijunShunyugakuTekiyoKanriEntity entity = 修正データ.toEntity();
                entity.setState(EntityDataState.Modified);
                dbT3116Dac.saveOrDeletePhysicalBy(entity);
            }
        }
        if (!削除データList.isEmpty()) {
            for (KijunShunyugakuTekiyoKanri 削除データ : 削除データList) {
                DbT3116KijunShunyugakuTekiyoKanriEntity entity = 削除データ.toEntity();
                entity.setState(EntityDataState.Deleted);
                dbT3116Dac.saveOrDeletePhysicalBy(entity);
            }
        }
    }
}
