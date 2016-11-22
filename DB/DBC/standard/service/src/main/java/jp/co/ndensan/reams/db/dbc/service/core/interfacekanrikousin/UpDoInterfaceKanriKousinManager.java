/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.interfacekanrikousin;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7109KubunShikyuGendoGakuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連インタフェース管理TBL更新
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class UpDoInterfaceKanriKousinManager {

    private final DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac;
    private final DbT7109KubunShikyuGendoGakuDac 居宅サービス区分支給限度額Dac;
    private static final RString 処理状態区分_終了 = new RString("3");
    private static final RString 交換情報識別番号 = new RString("531");
    private static final RString MESSAGE_処理対象年月 = new RString("処理対象年月");
    private static final RString MESSAGE_再処理区分 = new RString("再処理区分");
    private static final RString MESSAGE_処理日時 = new RString("処理日時");
    private static final RString ERROR_MESSAGE = new RString("国保連インターフェース管理に更新対象レコードが存在しません");
    private static final RString 再処理可能 = new RString("1");

    /**
     * 国保連情報取込共通処理（国保連インタフェース管理TBL更新）のコンストラクタ。
     *
     */
    public UpDoInterfaceKanriKousinManager() {
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
        this.居宅サービス区分支給限度額Dac = InstanceProvider.create(DbT7109KubunShikyuGendoGakuDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link UpDoInterfaceKanriKousinManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link UpDoInterfaceKanriKousinManager}のインスタンス
     */
    public static UpDoInterfaceKanriKousinManager createInstance() {
        return InstanceProvider.create(UpDoInterfaceKanriKousinManager.class);
    }

    /**
     * 居宅サービス区分支給限度額取得
     *
     * @return List<DbT7109KubunShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7109KubunShikyuGendoGakuEntity> get居宅サービス区分支給限度額() {
        return this.居宅サービス区分支給限度額Dac.selectAll();
    }

    /**
     * 国保連インタフェース管理TBL更新
     *
     * @param 処理対象年月 FlexibleYearMonth
     * @param 再処理区分 RString
     * @param 処理日時 YMDHMS
     * @param 異動レコード件数 int
     * @return 保存成功TRUE エントリ情報削除する時例外が発生したFALSE
     */
    @Transaction
    public boolean updateInterfaceKanriTbl(RYearMonth 処理対象年月, RString 再処理区分, YMDHMS 処理日時,
            int 異動レコード件数) {
        requireNonNull(処理対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_処理対象年月.toString()));
        requireNonNull(再処理区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_再処理区分.toString()));
        requireNonNull(処理日時, UrSystemErrorMessages.値がempty.getReplacedMessage(MESSAGE_処理日時.toString()));
        DbT3104KokuhorenInterfaceKanriEntity entity = 国保連インターフェース管理Dac.
                selectByKeyUndeleted(new FlexibleYearMonth(処理対象年月.toString()), 交換情報識別番号);
        if (null != entity) {
            entity.setShoriJotaiKubun(処理状態区分_終了);
            entity.setShoriJisshiTimestamp(処理日時);
            if (再処理可能.equals(再処理区分)) {
                entity.setSaiShoriKanoKubun(true);
            } else {
                entity.setSaiShoriKanoKubun(false);
            }
            Decimal 処理実行回数 = entity.getShoriJikkoKaisu();
            if (処理実行回数 != null) {
                処理実行回数 = 処理実行回数.add(Decimal.ONE);
                entity.setShoriJikkoKaisu(処理実行回数);
            }
            entity.setFileKensu1(異動レコード件数);
            entity.setCtrlRecordKensu(異動レコード件数);
            entity.setCtrlShoriYM(new FlexibleYearMonth(処理対象年月.toString()));
        } else {
            throw new BatchInterruptedException(ERROR_MESSAGE.toString());
        }
        return 1 == 国保連インターフェース管理Dac.save(entity);
    }
}
