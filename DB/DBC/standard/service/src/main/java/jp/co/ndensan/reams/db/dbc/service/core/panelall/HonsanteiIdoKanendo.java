/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.panelall;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_新規。
 *
 * @reamsid_L DBC-5010-010 lihang
 */
public class HonsanteiIdoKanendo {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private static final RString 定数サブ業務コード = new RString("サブ業務コード");
    private static final RString 定数処理名 = new RString("処理名");
    private final RString 定数市町村コード = new RString("01");

    /**
     * コンストラクタです。
     */
    HonsanteiIdoKanendo() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7022ShoriDateKanriDac
     */
    HonsanteiIdoKanendo(DbT7022ShoriDateKanriDac dbT7022ShoriDateKanriDac) {
        this.処理日付管理Dac = dbT7022ShoriDateKanriDac;
    }

    /**
     * 初期化します
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HonsanteiIdoKanendo}のインスタンス
     */
    public static HonsanteiIdoKanendo createInstance() {
        return InstanceProvider.create(HonsanteiIdoKanendo.class);
    }

    /**
     * 基準日を取得します
     *
     * @param 処理名 RString
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード RString
     * @return List<ShoriDateKanri>
     */
    public List<FlexibleYear> getNendo(SubGyomuCode サブ業務コード,
            RString 市町村コード,
            RString 処理名) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数サブ業務コード.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数市町村コード.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(定数処理名.toString()));
        List<ShoriDateKanri> 処理日付管理List = new ArrayList<>();
        return 処理日付管理Dac.selectNendo(サブ業務コード, 市町村コード, 処理名);
    }

}
