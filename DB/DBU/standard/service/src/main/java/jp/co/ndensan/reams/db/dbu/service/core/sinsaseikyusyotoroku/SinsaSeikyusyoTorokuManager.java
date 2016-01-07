/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.sinsaseikyusyotoroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7001FufukuMoshitateDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査請求書登録を登録するクラスです。
 */
public class SinsaSeikyusyoTorokuManager {

    private final DbT7001FufukuMoshitateDac 審査請求書登録dac;
    private static final RString 画面モード_追加モード = new RString("追加");
    private static final RString 画面モード_修正モード = new RString("修正");

    /**
     * コンストラクタです。
     */
    public SinsaSeikyusyoTorokuManager() {
        審査請求書登録dac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7001FufukuMoshitateDac}
     */
    SinsaSeikyusyoTorokuManager(DbT7001FufukuMoshitateDac dac) {
        this.審査請求書登録dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SinsaSeikyusyoTorokuManager}のインスタンスを返します。
     *
     *
     * @return SinsaSeikyusyoTorokuManager
     */
    public static SinsaSeikyusyoTorokuManager createInstance() {
        return InstanceProvider.create(SinsaSeikyusyoTorokuManager.class);
    }

    /**
     * 画面入力した条件より　審査請求書明細情報を取得します
     *
     * @param 識別コード 識別コード
     * @param 原処分被保険者番号 原処分被保険者番号
     * @param 審査請求届出日 審査請求届出日
     *
     * @return 審査請求書明細情報
     */
    @Transaction
    public FufukuMoshitate getSinsaSeikyusyoMeisaiJoho(ShikibetsuCode 識別コード, HihokenshaNo 原処分被保険者番号, FlexibleDate 審査請求届出日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        DbT7001FufukuMoshitateEntity entity = 審査請求書登録dac.selectByKey(識別コード, 原処分被保険者番号, 審査請求届出日);
        if (entity == null) {
            entity = new DbT7001FufukuMoshitateEntity();
        }
        return new FufukuMoshitate(entity);
    }

    /**
     * 審査請求書明細情報を登録します
     *
     * @param fufukuMoshitate 不服審査申立情報
     *
     * @return 登録件数
     */
    @Transaction
    public int intSinsaSeikyusyomeisaiJoho(FufukuMoshitate fufukuMoshitate) {
        return 審査請求書登録dac.save(fufukuMoshitate.toEntity());
    }

    /**
     * 審査請求書明細情報データを更新します
     *
     * @param 編集後の不服審査申立情報 編集後の不服審査申立情報
     */
    @Transaction
    public void updSinsaSeikyusyomeisaiJoho(FufukuMoshitate 編集後の不服審査申立情報) {

        編集後の不服審査申立情報.toEntity().initializeMd5();
        審査請求書登録dac.save(編集後の不服審査申立情報.modifiedModel().toEntity());
    }

    /**
     * 審査請求書明細情報を削除します
     *
     * @param fufukuMoshitate 審査請求書
     */
    @Transaction
    public void delSinsaSeikyusyomeisaiJoho(FufukuMoshitate fufukuMoshitate) {
        fufukuMoshitate.toEntity().initializeMd5();
        審査請求書登録dac.saveOrDeletePhysicalBy(fufukuMoshitate.deleted().toEntity());
    }

    /**
     * 審査請求届出日の重複チェック処理
     *
     * @param 識別コード 識別コード
     * @param 原処分被保険者番号 原処分被保険者番号
     * @param 審査請求届出日 審査請求届出日
     * @param gamennmodel 画面モード
     * @param shinsaSeikyuTodokedeYMD 審査請求届出日
     *
     * @return チェックフラグ
     */
    public boolean checkSinsaSeikyuTodokede(ShikibetsuCode 識別コード, HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日, RString gamennmodel, FlexibleDate shinsaSeikyuTodokedeYMD) {
        boolean isJuuHuku = true;
        DbT7001FufukuMoshitateEntity fufukuMoshitateEntity = 審査請求書登録dac.selectByKey(識別コード, 原処分被保険者番号, shinsaSeikyuTodokedeYMD);
        if (fufukuMoshitateEntity == null) {
            return isJuuHuku;
        }
        if (画面モード_追加モード.equals(gamennmodel)) {
            isJuuHuku = false;
        } else if (画面モード_修正モード.equals(gamennmodel)) {
            if (!(fufukuMoshitateEntity.getShikibetsuCode().equals(識別コード)
                    && fufukuMoshitateEntity.getGenshobunsHihokennshaNo().equals(原処分被保険者番号)
                    && fufukuMoshitateEntity.getShinsaSeikyuTodokedeYMD().equals(審査請求届出日))) {
                isJuuHuku = false;
            }
        }
        return isJuuHuku;
    }
}
