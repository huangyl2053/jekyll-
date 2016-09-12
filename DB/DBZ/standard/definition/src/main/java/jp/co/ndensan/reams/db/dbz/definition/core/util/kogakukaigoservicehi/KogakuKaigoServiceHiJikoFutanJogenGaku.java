/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.util.kogakukaigoservicehi;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.kogakujikofutan.Kogaku201504JikofutanJogen;
import jp.co.ndensan.reams.db.dbz.definition.core.kogakujikofutan.KogakuJikofutanJogen;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費支給による自己負担上限月額のクラスです。
 *
 * @reamsid_L DBA-1290-040 lishengli
 */
public class KogakuKaigoServiceHiJikoFutanJogenGaku {

    private static final FlexibleDate 年月日_20150401 = new FlexibleDate("20150401");
    private static final RString MESSAGE_基準日 = new RString("基準日");

    /**
     * コンストラクタです。
     */
    public KogakuKaigoServiceHiJikoFutanJogenGaku() {
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理です。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get第1段階(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return KogakuJikofutanJogen.第1段階_高額介護サービス費支給_自己負担上限月額.get名称();
        } else {
            return Kogaku201504JikofutanJogen.第1段階_高額介護サービス費支給_201504以降_自己負担上限月額.get名称();
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理です。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get第2段階(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return KogakuJikofutanJogen.第2段階_高額介護サービス費支給_自己負担上限月額.get名称();
        } else {
            return Kogaku201504JikofutanJogen.第2段階_高額介護サービス費支給_201504以降_自己負担上限月額.get名称();
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理です。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get第3段階(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return KogakuJikofutanJogen.第3段階_高額介護サービス費支給_自己負担上限月額.get名称();
        } else {
            return Kogaku201504JikofutanJogen.第3段階_高額介護サービス費支給_201504以降_自己負担上限月額.get名称();
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理です。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get第4段階(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGE_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return Kogaku201504JikofutanJogen.第4段階_高額介護サービス費支給_201504以降_自己負担上限月額.get名称();
        }
    }
}
