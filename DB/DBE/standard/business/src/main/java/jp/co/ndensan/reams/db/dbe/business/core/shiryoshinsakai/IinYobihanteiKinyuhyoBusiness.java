/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 委員用予備判定記入表情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinYobihanteiKinyuhyoBusiness {

    private final HanteiJohoEntity entity;
    private final IinTokkiJikouItiziHanteiProcessParameter paramter;

    public IinYobihanteiKinyuhyoBusiness(
            HanteiJohoEntity entity,
            IinTokkiJikouItiziHanteiProcessParameter paramter) {
        this.entity = entity;
        this.paramter = paramter;
    }

    public RString get作成年月日() {
        return get作成日期();
    }

    public RString get審査会開催番号() {
        return paramter.getShinsakaiKaisaiNo();
    }

    public RString getNo() {
        return new RString(entity.getShinsakaiOrder());
    }

    public RString get申請区分() {
        if (entity.getShinseijiKubunCode() == null || entity.getShinseijiKubunCode().isEmpty()) {
            return RString.EMPTY;
        }
        return NinteiShinseiShinseijiKubunCode.toValue(
                entity.getShinseijiKubunCode().getColumnValue()).get名称();
    }

    public RString get被保険者区分() {
        if (RString.isNullOrEmpty(entity.getHihokenshaKubunCode())) {
            return RString.EMPTY;
        }
        return HihokenshaKubunCode.toValue(entity.getHihokenshaKubunCode()).get名称();
    }

    public RString get性別() {
        if (entity.getSeibetsu() == null || entity.getSeibetsu().isEmpty()) {
            return RString.EMPTY;
        }
        return Seibetsu.toValue(entity.getSeibetsu().getColumnValue()).get名称();
    }

    public RString get年齢() {
        return new RString(entity.getAge());
    }

    public RString get前回二次判定() {
        if (entity.getYokaigoJotaiKubunCode() == null || entity.getYokaigoJotaiKubunCode().isEmpty()) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubun09.toValue(entity.getYokaigoJotaiKubunCode().getColumnValue()).get名称();
    }

    public RString get前回認定有効期間() {
        return new RString(entity.getHanteiNinteiYukoKikan());
    }

    public RString get一次判定() {
        if (entity.getIchijiHanteiKekkaCode() == null || entity.getIchijiHanteiKekkaCode().isEmpty()) {
            return RString.EMPTY;
        }
        return IchijiHanteiKekkaCode09.toValue(entity.getIchijiHanteiKekkaCode().getColumnValue()).get名称();
    }

    public RString get二次判定() {
        return RString.EMPTY;
    }

    public RString get状態像() {
        return RString.EMPTY;
    }

    public RString get認定有効期間() {
        return RString.EMPTY;
    }

    public RString get特定疾病コード() {
        if (entity.getNigoTokuteiShippeiCode() == null || RString.isNullOrEmpty(entity.getNigoTokuteiShippeiCode().getColumnValue())) {
            return RString.EMPTY;
        }
        return entity.getNigoTokuteiShippeiCode().getColumnValue();
    }

    public RString get特定疾病名称() {
        if (entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty()) {
            return RString.EMPTY;
        }
        return TokuteiShippei.toValue(entity.getNigoTokuteiShippeiCode().getColumnValue()).get名称();
    }

    public RString get調査員特記事項() {
        return RString.EMPTY;
    }

    public RString get主治医意見書() {
        return RString.EMPTY;
    }

    private RString get作成日期() {
        RStringBuilder builder = new RStringBuilder();
        return builder.append(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString())
                .append(" ")
                .append(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).toString())
                .append(" ")
                .append("作成")
                .toRString();
    }
}
