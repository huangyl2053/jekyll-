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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7001FufukuMoshitateDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 不服審査申立情報を管理するクラスです。
 */
public class FufukuMoshitateManager {

    private final DbT7001FufukuMoshitateDac dac;

    /**
     * コンストラクタです。
     */
    public FufukuMoshitateManager() {
        dac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7001FufukuMoshitateDac}
     */
    FufukuMoshitateManager(DbT7001FufukuMoshitateDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する不服審査申立情報を返します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunsHihokennshaNo
     * @param 審査請求届出日 ShinsaSeikyuTodokedeYMD
     * @return FufukuMoshitate
     */
    @Transaction
    public FufukuMoshitate get不服審査申立情報(
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));

//        DbT7001FufukuMoshitateEntity entity = dac.selectByKey(
//                証記載保険者番号,
//                識別コード,
//                原処分被保険者番号,
//                審査請求届出日);
//        if (entity == null) {
//            return null;
//        }
//        entity.initializeMd5();
        return new FufukuMoshitate(new DbT7001FufukuMoshitateEntity());
    }

    /**
     * 不服審査申立情報を全件返します。
     *
     * @return List<FufukuMoshitate>
     */
    @Transaction
    public List<FufukuMoshitate> get不服審査申立情報一覧() {
        List<FufukuMoshitate> businessList = new ArrayList<>();

        for (DbT7001FufukuMoshitateEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new FufukuMoshitate(entity));
        }

        return businessList;
    }

    /**
     * 不服審査申立情報{@link FufukuMoshitate}を保存します。
     *
     * @param 不服審査申立情報 {@link FufukuMoshitate}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save不服審査申立情報(FufukuMoshitate 不服審査申立情報) {
        requireNonNull(不服審査申立情報, UrSystemErrorMessages.値がnull.getReplacedMessage("不服審査申立情報"));
        if (!不服審査申立情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(不服審査申立情報.toEntity());
    }
}
