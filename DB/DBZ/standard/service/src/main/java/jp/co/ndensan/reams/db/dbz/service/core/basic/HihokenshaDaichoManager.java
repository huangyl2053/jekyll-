/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.hihokenshadaicho.HihokenshaDaichoSearchCondition;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT1001HihokenshaDaichoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理を管理するクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public class HihokenshaDaichoManager {

    private final DbT1001HihokenshaDaichoDac dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoManager() {
        dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1001HihokenshaDaichoDac}
     * @param mapperProvider mapperProvider
     */
    HihokenshaDaichoManager(DbT1001HihokenshaDaichoDac dac, MapperProvider mapperProvider) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoManager}のインスタンス
     */
    public static HihokenshaDaichoManager createInstance() {
        return InstanceProvider.create(HihokenshaDaichoManager.class);
    }

    /**
     * 主キーに合致する被保険者台帳管理を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return HihokenshaDaicho
     */
    @Transaction
    public HihokenshaDaicho get被保険者台帳管理(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbT1001HihokenshaDaichoEntity entity = dac.selectByKey(
                被保険者番号,
                異動日,
                枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 引数から指定した被保険者番号・市町村コードに該当する被保険者台帳情報を取得します。 取得した被保険者台帳情報は、異動日でDescされています。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @return 最新の履歴1件
     */
    public List<HihokenshaDaicho> get被保険者台帳管理DescOrderByShoriTimestamp(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        List<HihokenshaDaicho> businessList = new ArrayList<>();

        List<DbT1001HihokenshaDaichoEntity> entityList = dac.selectByHihokenshaNoAndShichosonCode(
                市町村コード,
                被保険者番号
        );

        for (DbT1001HihokenshaDaichoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new HihokenshaDaicho(entity));
        }

        return businessList;
    }

    /**
     * 被保険者台帳管理を全件返します。
     *
     * @return List<HihokenshaDaicho>
     */
    @Transaction
    public List<HihokenshaDaicho> get被保険者台帳管理一覧() {
        List<HihokenshaDaicho> businessList = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new HihokenshaDaicho(entity));
        }

        return businessList;
    }

    /**
     * 市町村コードと識別コードを元に被保険者台帳を検索し、該当する情報の中から最新1件を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @return 該当する被保険者台帳情報の内、最新の1件
     */
    public HihokenshaDaicho get最新被保険者台帳(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbT1001HihokenshaDaichoEntity entity = dac.selectForNewestHihokenshaDaichoData(
                市町村コード,
                識別コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 被保険者番号に被保険者台帳を検索します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<HihokenshaDaicho>
     */
    public List<HihokenshaDaicho> get最新被保険者台帳(HihokenshaNo 被保険者番号) {
        List<HihokenshaDaicho> businessList = new ArrayList<>();
        List<DbT1001HihokenshaDaichoEntity> entityList = dac.get被保険者台帳管理情報(被保険者番号);
        for (DbT1001HihokenshaDaichoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new HihokenshaDaicho(entity));
        }

        return businessList;
    }

    /**
     * 被保険者番号、異動日で最大の枝番を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @return List<HihokenshaDaicho>
     */
    public RString get最大の枝番(HihokenshaNo 被保険者番号, FlexibleDate 異動日) {
        DbT1001HihokenshaDaichoEntity entity = dac.selectMaxEdaNoByKey(被保険者番号, 異動日);
        if (entity == null) {
            return null;
        }
        return entity.getEdaNo();
    }

    /**
     * 基準日時点の被保険者番号に該当する被保険者台帳情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準年月日 基準年月日
     * @return 該当する被保険者台帳情報の内、最新の1件
     */
    public HihokenshaDaicho find被保険者台帳(HihokenshaNo 被保険者番号, FlexibleDate 基準年月日) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        DbT1001HihokenshaDaichoEntity entity = dac.selectByHihokenshaNoAndKijunDate(被保険者番号, 基準年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 基準日時点の識別コードに該当する被保険者台帳情報を取得します。
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 該当する被保険者台帳情報
     */
    public HihokenshaDaicho find被保険者台帳(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {

        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        DbT1001HihokenshaDaichoEntity entity = dac.selectByShikibetsuCodeAndKijunDate(識別コード, 基準年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 識別コードに該当する最新の被保険者台帳を取得します。
     *
     * @param 識別コード 識別コード
     * @return 該当する被保険者台帳情報の内、最新の1件
     */
    public HihokenshaDaicho find最新被保険者台帳(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbT1001HihokenshaDaichoEntity entity = dac.selectByShikibetsuCode(識別コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 異動日に該当する最新の被保険者台帳を取得します。
     *
     * @param 異動日 異動日
     * @return 該当する被保険者台帳情報の内、最新の1件
     */
    public HihokenshaDaicho find最新被保険者台帳(FlexibleDate 異動日) {
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        DbT1001HihokenshaDaichoEntity entity = dac.selectBy異動日(異動日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 最新の資格の情報を取得します。
     *
     * @param param HihokenshaDaichoSearchCondition
     * @return 最新の資格の情報を取得
     */
    public HihokenshaDaicho find資格の情報(HihokenshaDaichoSearchCondition param) {

        DbT1001HihokenshaDaichoEntity entity = mapperProvider.create(
                IDbT1001HihokenshaDaichoMapper.class).get資格の情報(param);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 識別コードが異なる、異動日が大きいの資格の情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @return 資格の情報
     */
    public HihokenshaDaicho get資格の情報For資格不整合(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード, FlexibleDate 異動日) {
        DbT1001HihokenshaDaichoEntity entity = dac.get資格の情報(被保険者番号, 識別コード, 異動日, new RString("1"));
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 被保険者番号、論理削除フラグで被保険者台帳から最新データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT1001HihokenshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public HihokenshaDaicho selectByHihokenshaNo(HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity entity = dac.selectByHihokenshaNo(被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 被保険者台帳管理{@link HihokenshaDaicho}を保存します。
     *
     * @param 被保険者台帳管理 {@link HihokenshaDaicho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save被保険者台帳管理(HihokenshaDaicho 被保険者台帳管理) {
        requireNonNull(被保険者台帳管理, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理"));
        if (!被保険者台帳管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(被保険者台帳管理.toEntity());
    }

}
