/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200061;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.servicecode.ServiceCodeIchiran_ChushutsuJokenKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodeichiran.ServicecodeIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.ServiceBunruiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.TaniSuShikibetsuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200061.ServiceCodeIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 帳票設計_DBCMNJ2006_サービスコード一覧表HeaderEditor
 *
 * @reamsid_L DBC-3310-040 jiangxiaolong
 */
public class ServiceCodeIchiranHeaderEditor
        implements IServiceCodeIchiranEditor {

    private final ServiceCodeIchiranParameter parameter;
    private static final RString 単位数単位 = new RString("【単位数単位】");
    private static final RString コロン = new RString("：");
    private static final RString スペース = new RString(" ");
    private static final RString 全角空白 = new RString("　");
    private static final RString サービスコード = new RString("サービスコード");
    private static final RString 中点 = new RString("・");

    /**
     * コンストラクタです
     *
     * @param parameter ServiceCodeIchiranParameter
     */
    public ServiceCodeIchiranHeaderEditor(ServiceCodeIchiranParameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public ServiceCodeIchiranSource edit(
            ServiceCodeIchiranSource source) {
        if (null == parameter) {
            return source;
        }
        Association 導入団体 = parameter.get導入団体();
        ServicecodeIchiranProcessParameter バッチパラメータ = parameter.getバッチパラメータ();
        DbT7131KaigoServiceNaiyouEntity kaigoServiceNaiyouEntity;
        List<TaniSuShikibetsuEntity> 単位数識別List = parameter.get単位数識別();
        RDateTime 作成日時 = parameter.get作成日時();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 作成日.concat(RString.FULL_SPACE).concat(作成時);
        if (null != 導入団体) {
            source.hokenshaNo = getColumnValue(導入団体.getLasdecCode_());
            source.hokenshaName = 導入団体.getShichosonName_();
        }
        source.kijunYM = doパターン62(バッチパラメータ.get基準年月());
        if (null != 単位数識別List) {
            for (TaniSuShikibetsuEntity 単位数識別 : 単位数識別List) {
                if (null == source.taniSetsumei) {
                    source.taniSetsumei = 単位数単位;
                }
                source.taniSetsumei = source.taniSetsumei.concat(スペース).concat(getColumnValue(単位数識別.getコード())).
                        concat(コロン).concat(単位数識別.get名称());
            }
        }

        if (バッチパラメータ.get抽出条件区分().equals(ServiceCodeIchiran_ChushutsuJokenKubun.サービスコードを指定.get名称())) {
            source.chushutsuJoken = サービスコード.concat(全角空白).concat(getColumnValue(バッチパラメータ.getサービス種類コード())).
                    concat(スペース).concat(バッチパラメータ.getサービス項目コード());
        } else if (バッチパラメータ.get抽出条件区分().equals(ServiceCodeIchiran_ChushutsuJokenKubun.サービス分類を指定.get名称())) {
            source.chushutsuJoken = getサービス分類();
        }

        if (null != parameter.getサービスコード一覧表()) {
            kaigoServiceNaiyouEntity = parameter.getサービスコード一覧表().get介護サービス内容();

            if (null != kaigoServiceNaiyouEntity) {
                RString 名称 = ServiceCategoryShurui.toValue(getColumnValue(kaigoServiceNaiyouEntity.getServiceShuruiCd())).get名称();
                source.serviceShurui = getColumnValue(kaigoServiceNaiyouEntity.getServiceShuruiCd())
                        .concat(スペース).concat(名称);
            }
        }
        return source;
    }

    private RString getサービス分類() {
        List<ServiceBunruiEntity> list = parameter.getサービス分類略称();
        if (null != list) {
            RString rs = null;
            for (ServiceBunruiEntity e : list) {
                if (null == e) {
                    continue;
                }
                if (null != rs) {
                    rs = rs.concat(中点).concat(e.get略称());
                } else {
                    rs = e.get略称();
                }
            }
            return rs;
        }
        return RString.EMPTY;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doパターン62(FlexibleYearMonth ym) {
        if (ym == null) {
            return RString.EMPTY;
        }
        return ym.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
