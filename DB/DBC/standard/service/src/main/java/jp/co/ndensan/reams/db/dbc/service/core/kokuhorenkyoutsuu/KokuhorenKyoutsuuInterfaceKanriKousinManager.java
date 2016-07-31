package jp.co.ndensan.reams.db.dbc.service.core.kokuhorenkyoutsuu;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連情報取込処理共通のビジネスです。<br>
 * 国保連インタフェース管理TBL更新
 *
 * @reamsid_L DBC-0980-530 zhangrui
 */
public class KokuhorenKyoutsuuInterfaceKanriKousinManager {

    private final DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac;

    private static final int 定数_0 = 0;
    private static final int 定数_1 = 1;
    private static final int 定数_2 = 2;
    private static final int 定数_3 = 3;
    private static final int 定数_4 = 4;
    private static final RString 処理状態区分_終了 = new RString("3");
    private static final RString ERROR_MESSAGE = new RString("国保連インタフェース管理テーブル");
    private static final RString MESSAGE_処理年月 = new RString("処理年月");
    private static final RString MESSAGE_交換情報識別番号 = new RString("交換情報識別番号");
    private static final RString MESSAGE_処理対象年月 = new RString("処理対象年月");
    private static final RString MESSAGE_レコード件数合計 = new RString("レコード件数合計");
    private static final RString MESSAGE_エントリ情報LIST = new RString("エントリ情報List");

    /**
     * 国保連情報取込共通処理（国保連インタフェース管理TBL更新）のコンストラクタ。
     *
     */
    public KokuhorenKyoutsuuInterfaceKanriKousinManager() {
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KokuhorenKyoutsuuInterfaceKanriKousinManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KokuhorenKyoutsuuInterfaceKanriKousinManager}のインスタンス
     */
    public static KokuhorenKyoutsuuInterfaceKanriKousinManager createInstance() {
        return InstanceProvider.create(KokuhorenKyoutsuuInterfaceKanriKousinManager.class);
    }

    /**
     * 国保連インタフェース管理TBL更新
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 交換情報識別番号 RString
     * @param 処理対象年月 FlexibleYearMonth
     * @param レコード件数合計 int
     * @param fileNameList List<RString>
     * @return 保存成功TRUE エントリ情報削除する時例外が発生したFALSE
     */
    @Transaction
    public boolean updateInterfaceKanriTbl(FlexibleYearMonth 処理年月, RString 交換情報識別番号, FlexibleYearMonth 処理対象年月,
            int レコード件数合計, List<RString> fileNameList) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_処理年月.toString()));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_交換情報識別番号.toString()));
        requireNonNull(処理対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_処理対象年月.toString()));
        requireNonNull(レコード件数合計, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_レコード件数合計.toString()));
        requireNonNull(fileNameList, UrSystemErrorMessages.値がempty.getReplacedMessage(MESSAGE_エントリ情報LIST.toString()));
        requireNonNull(fileNameList, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_エントリ情報LIST.toString()));
        DbT3104KokuhorenInterfaceKanriEntity entity = 国保連インターフェース管理Dac.selectByKeyUndeleted(処理年月, 交換情報識別番号);
        if (null != entity) {
            entity.setShoriJotaiKubun(処理状態区分_終了);
            entity.setShoriJisshiTimestamp(YMDHMS.now());
            entity.setSaiShoriFukaKubun(false);
            entity.setShoriJikkoKaisu(getNotNull(entity.getShoriJikkoKaisu()));
            entity.setFileName1(getFileName(fileNameList, 定数_0));
            entity.setFileName2(getFileName(fileNameList, 定数_1));
            entity.setFileName3(getFileName(fileNameList, 定数_2));
            entity.setFileName4(getFileName(fileNameList, 定数_3));
            entity.setFileName5(getFileName(fileNameList, 定数_4));
            entity.setCtrlRecordKensu(レコード件数合計);
            entity.setCtrlShoriYM(処理対象年月);
            entity.setState(EntityDataState.Modified);
        } else {
            throw new BatchInterruptedException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().
                    replace(ERROR_MESSAGE.toString()).toString());
        }
        return 1 == 国保連インターフェース管理Dac.save(entity);
    }

    private RString getFileName(List<RString> エントリ情報List, int 定数) {
        return (null == エントリ情報List || エントリ情報List.isEmpty() || エントリ情報List.size() <= 定数)
                ? RString.EMPTY : エントリ情報List.get(定数);
    }

    private Decimal getNotNull(Decimal decimal) {
        return (null == decimal) ? Decimal.ONE : decimal.add(Decimal.ONE);
    }

}
