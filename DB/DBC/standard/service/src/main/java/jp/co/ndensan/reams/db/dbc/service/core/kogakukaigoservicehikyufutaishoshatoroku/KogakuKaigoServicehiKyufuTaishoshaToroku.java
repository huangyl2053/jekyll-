/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020040.DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額介護サービス費給付対象者登録です。
 *
 * @reamsid_L DBC-2010-080 jiangzongyue
 */
public class KogakuKaigoServicehiKyufuTaishoshaToroku {

    private static final RString PARAMETER = new RString("交換情報識別番号");
    private final DbT3104KokuhorenInterfaceKanriDac dbT3104KokuhorenKanriDac;

    /**
     * コンストラクタです。
     */
    public KogakuKaigoServicehiKyufuTaishoshaToroku() {
        dbT3104KokuhorenKanriDac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * 高額介護サービス費給付対象者登録クラスのコンストラクタです(テスト用)。
     *
     * @param DbT3104KokuhorenInterfaceKanriDac dbT3104KokuhorenKanriDac
     */
    KogakuKaigoServicehiKyufuTaishoshaToroku(DbT3104KokuhorenInterfaceKanriDac dbT3104KokuhorenKanriDac) {

        this.dbT3104KokuhorenKanriDac = dbT3104KokuhorenKanriDac;

    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuKaigoServicehiKyufuTaishoshaToroku}のインスタンス
     */
    public static KogakuKaigoServicehiKyufuTaishoshaToroku createInstance() {
        return InstanceProvider.create(KogakuKaigoServicehiKyufuTaishoshaToroku.class);
    }

    /**
     * 登録先台帳検索結果を返します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @return 検索結果
     */
    public KokuhorenInterfaceKanri getSinsaYM(RString 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(PARAMETER.toString()));
        List<DbT3104KokuhorenInterfaceKanriEntity> list = dbT3104KokuhorenKanriDac.selectSinsaYM(交換情報識別番号);
        if (list == null || list.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.処理状態処理前未設定.getMessage());
        } else if (2 <= list.size()) {
            throw new ApplicationException(DbcErrorMessages.高額判定_処理状態処理前数不正.getMessage());
        }
        return new KokuhorenInterfaceKanri(list.get(0));
    }

    /**
     * バッチパラメータ取得
     *
     * @param 審査年月From RString
     * @param 審査年月To RString
     * @param 出力フラグ RString
     * @param 出力順ID Long
     * @return DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter
     */
    public DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter getKogakuKaigoServicehiKyufuTaishoshaTorokuBatchParameter(
            RString 審査年月From, RString 審査年月To, boolean 出力フラグ, Long 出力順ID) {
        DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter param = new DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter();
        if (!RString.isNullOrEmpty(審査年月From)) {
            param.setShinsaYMFrom(new FlexibleYearMonth(審査年月From));
        } else {
            param.setShinsaYMFrom(new FlexibleYearMonth(RString.EMPTY));
        }
        if (!RString.isNullOrEmpty(審査年月To)) {
            param.setShinsaYMTo(new FlexibleYearMonth(審査年月To));
        } else {
            param.setShinsaYMTo(new FlexibleYearMonth(RString.EMPTY));
        }
        param.setShuturyokuFlg(出力フラグ);
        param.setShuturyokuJunn(出力順ID);
        return param;
    }
}
