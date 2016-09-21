/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd5720011;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.JyukyushaDaichoIdoCheckListEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.LowerEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.UpperEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.IsKyuSoti;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳異動チェックリストEntity設定のビジネスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public class JyukyushaDaichoIdoCheckListOutputResult {

    /**
     * UpperEntityの設定メッソドです。
     *
     * @param entity entity
     * @return UpperEntity
     */
    public UpperEntity getUpperEntity(JyukyushaDaichoIdoCheckListEntity entity) {
        UpperEntity upper = new UpperEntity();
        if (entity != null) {
            保険者(entity, upper);
            年月日(entity, upper);
            宛名(entity, upper);
            区分(entity, upper);
        }
        return upper;
    }

    /**
     * LowerEntityの設定メッソドです。
     *
     * @param entity entity
     * @return LowerEntity
     */
    public LowerEntity getLowerEntity(JyukyushaDaichoIdoCheckListEntity entity) {
        LowerEntity lower = new LowerEntity();
        if (entity != null) {
            要介護認定状態区分コード(entity, lower);
            認定有効期間終了(entity, lower);
            コード(entity, lower);
            名称(entity, lower);
            受給申請事由(entity, lower);
        }
        return lower;
    }

    private LowerEntity 要介護認定状態区分コード(JyukyushaDaichoIdoCheckListEntity entity, LowerEntity lower) {
        if (entity.get要介護認定状態区分コード() != null && !entity.get要介護認定状態区分コード().isEmpty()) {
            if (entity.get厚労省IF識別コード().value().equals(new RString("99A"))) {
                lower.set要介護度(YokaigoJotaiKubun99.toValue(entity.get要介護認定状態区分コード().value()).get名称());
            }
            if (entity.get厚労省IF識別コード().value().equals(new RString("02A"))) {
                lower.set要介護度(YokaigoJotaiKubun02.toValue(entity.get要介護認定状態区分コード().value()).get名称());
            }
            if (entity.get厚労省IF識別コード().value().equals(new RString("06A"))) {
                lower.set要介護度(YokaigoJotaiKubun06.toValue(entity.get要介護認定状態区分コード().value()).get名称());
            }
            if (entity.get厚労省IF識別コード().value().equals(new RString("09A"))
                    || entity.get厚労省IF識別コード().value().equals(new RString("09B"))) {
                lower.set要介護度(YokaigoJotaiKubun09.toValue(entity.get要介護認定状態区分コード().value()).get名称());
            }
        }
        return lower;
    }

    private LowerEntity 認定有効期間終了(JyukyushaDaichoIdoCheckListEntity entity, LowerEntity lower) {
        if (entity.get認定有効期間終了年月日() != null && !entity.get認定有効期間終了年月日().isEmpty()) {
            lower.set認定有効終了日(entity.get認定有効期間終了年月日());
        }
        return lower;
    }

    private LowerEntity コード(JyukyushaDaichoIdoCheckListEntity entity, LowerEntity lower) {
        if (entity.get管内管外区分().equals(new RString("1"))) {
            lower.set住所コード(new Code(entity.get町域コード().getColumnValue()));
        } else if (entity.get管内管外区分().equals(new RString("2"))) {
            lower.set住所コード(new Code(entity.get全国住所コード().getColumnValue()));
        }
        if (entity.get行政区コード() != null && !entity.get行政区コード().isEmpty()) {
            lower.set行政区コード(entity.get行政区コード());
        }
        return lower;
    }

    private LowerEntity 名称(JyukyushaDaichoIdoCheckListEntity entity, LowerEntity lower) {
        if (entity.get行政区名() != null && !entity.get行政区名().isEmpty()) {
            lower.set行政区(entity.get行政区名());
        }
        if (entity.get名称() != null && !entity.get名称().isEmpty()) {
            lower.set氏名(entity.get名称());
        }
        lower.set年齢(entity.get年齢());
        return lower;
    }

    private LowerEntity 受給申請事由(JyukyushaDaichoIdoCheckListEntity entity, LowerEntity lower) {
        if (entity.get受給申請事由() != null && !entity.get受給申請事由().isEmpty()) {
            lower.set受給申請事由(JukyuShinseiJiyu.toValue(entity.get受給申請事由().getColumnValue()).get名称());
        }
        if (entity.is旧措置者フラグ()) {
            lower.set旧措置者(IsKyuSoti.toValue(true).get名称());
        } else {
            lower.set旧措置者(IsKyuSoti.toValue(false).get名称());
        }
        if (entity.get直近異動事由コード() != null && !entity.get直近異動事由コード().isEmpty()) {
            lower.set処理内容(ChokkinIdoJiyuCode.toValue(entity.get直近異動事由コード().getColumnValue()).get名称());
        }
        return lower;
    }

    private UpperEntity 保険者(JyukyushaDaichoIdoCheckListEntity entity, UpperEntity upper) {
        if (entity.get市町村コード() != null && !entity.get市町村コード().isEmpty()) {
            upper.set保険者番号(entity.get市町村コード());
        }
        if (entity.get市町村名称() != null && !entity.get市町村名称().isEmpty()) {
            upper.set保険者名称(entity.get市町村名称());
        }
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
            upper.set被保険者番号(entity.get被保険者番号());
        }
        return upper;
    }

    private UpperEntity 年月日(JyukyushaDaichoIdoCheckListEntity entity, UpperEntity upper) {
        if (entity.get受給申請年月日() != null && !entity.get受給申請年月日().isEmpty()) {
            upper.set受給申請日(entity.get受給申請年月日());
        }
        if (entity.get認定年月日() != null && !entity.get認定年月日().isEmpty()) {
            upper.set認定日(entity.get認定年月日());
        }
        if (entity.get認定有効期間開始年月日() != null && !entity.get認定有効期間開始年月日().isEmpty()) {
            upper.set認定有効開始日(entity.get認定有効期間開始年月日());
        }
        if (entity.get喪失年月日() != null && !entity.get喪失年月日().isEmpty()) {
            upper.set喪失年月日(entity.get喪失年月日());
        }
        return upper;
    }

    private UpperEntity 宛名(JyukyushaDaichoIdoCheckListEntity entity, UpperEntity upper) {
        if (entity.get識別コード() != null && !entity.get識別コード().isEmpty()) {
            upper.set識別コード(entity.get識別コード());
        }
        if (entity.get住所() != null && !entity.get住所().isEmpty()) {
            upper.set住所(entity.get住所());
        }
        if (entity.getカナ名称() != null && !entity.getカナ名称().isEmpty()) {
            upper.setフリガナ(entity.getカナ名称());
        }
        if (entity.get生年月日() != null && !entity.get生年月日().isEmpty()) {
            upper.set生年月日(entity.get生年月日());
        }
        return upper;
    }

    private UpperEntity 区分(JyukyushaDaichoIdoCheckListEntity entity, UpperEntity upper) {
        if (entity.is削除フラグ()) {
            upper.set異動区分(new RString("削除"));
        } else if (!entity.is削除フラグ() && entity.getUpdate回数() == 0) {
            upper.set異動区分(new RString("新規"));
        } else if (!entity.is削除フラグ() && entity.getUpdate回数() >= 0) {
            upper.set異動区分(new RString("修正"));
        }

        if (entity.getデータ区分() != null && !entity.getデータ区分().isEmpty()) {
            upper.set異動事由(Datakubun.toValue(entity.getデータ区分().getColumnValue()).get名称());
        }
        if (entity.get有効無効区分() != null && !entity.get有効無効区分().isEmpty()) {
            upper.set有効無効(YukoMukoKubun.toValue(entity.get有効無効区分().getColumnValue()).get名称());
        }
        return upper;
    }
}
