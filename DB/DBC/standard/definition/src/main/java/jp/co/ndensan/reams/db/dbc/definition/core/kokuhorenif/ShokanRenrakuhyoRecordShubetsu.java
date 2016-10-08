/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票レコード種別を表す列挙型です。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public enum ShokanRenrakuhyoRecordShubetsu {

    /**
     * コード:01 名称:基本情報レコード 略称:定義なし
     */
    基本情報レコード("01", "基本情報レコード"),
    /**
     * コード:02 名称:明細情報レコード 略称:定義なし
     */
    明細情報レコード("02", "明細情報レコード"),
    /**
     * コード:14 名称:明細情報_住所地特例レコード 略称:定義なし
     */
    明細情報_住所地特例レコード("14", "明細情報_住所地特例レコード"),
    /**
     * コード:03 名称:緊急時施設療養情報レコード 略称:定義なし
     */
    緊急時施設療養情報レコード("03", "緊急時施設療養情報レコード"),
    /**
     * コード:13 名称:所定疾患施設療養費等情報レコード 略称:定義なし
     */
    所定疾患施設療養費等情報レコード("13", "所定疾患施設療養費等情報レコード"),
    /**
     * コード:04 名称:特定診療費_特別療養費情報レコード 略称:定義なし
     */
    特定診療費_特別療養費情報レコード("04", "特定診療費_特別療養費情報レコード"),
    /**
     * コード:05 名称:食事費用情報レコード 略称:定義なし
     */
    食事費用情報レコード("05", "食事費用情報レコード"),
    /**
     * コード:06 名称:サービス計画情報レコード 略称:定義なし
     */
    サービス計画情報レコード("06", "サービス計画情報レコード"),
    /**
     * コード:07 名称:福祉用具販売費情報レコード 略称:定義なし
     */
    福祉用具販売費情報レコード("07", "福祉用具販売費情報レコード"),
    /**
     * コード:08 名称:住宅改修費情報レコード 略称:定義なし
     */
    住宅改修費情報レコード("08", "住宅改修費情報レコード"),
    /**
     * コード:10 名称:集計情報レコード 略称:定義なし
     */
    集計情報レコード("10", "集計情報レコード"),
    /**
     * コード:11 名称:特定入所者介護サービス費用情報レコード 略称:定義なし
     */
    特定入所者介護サービス費用情報レコード("11", "特定入所者介護サービス費用情報レコード"),
    /**
     * コード:12 名称:社会福祉法人軽減額情報レコード 略称:定義なし
     */
    社会福祉法人軽減額情報レコード("12", "社会福祉法人軽減額情報レコード");

    private final RString code;
    private final RString fullName;

    private ShokanRenrakuhyoRecordShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 償還連絡票レコード種別のコードを返します。
     *
     * @return 償還連絡票レコード種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 償還連絡票レコード種別の名称を返します。
     *
     * @return 償還連絡票レコード種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 償還連絡票レコード種別のコードと一致する内容を探します。
     *
     * @param code 償還連絡票レコード種別のコード
     * @return {@code code} に対応する償還連絡票レコード種別
     */
    public static ShokanRenrakuhyoRecordShubetsu toValue(RString code) {
        for (ShokanRenrakuhyoRecordShubetsu shokanRenrakuhyoRecordShubetsu : ShokanRenrakuhyoRecordShubetsu.values()) {
            if (shokanRenrakuhyoRecordShubetsu.code.equals(code)) {
                return shokanRenrakuhyoRecordShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
