/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）の処理条件を扱います。
 */
final class TorikomiConditions {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString RSTRING_1 = new RString("1");
    private final NinteiShinsakaiKekkaDataTorikomiDiv div;
    private TorikomiTaishoData torikomiTaisho;
    private TorikomiNaiyo torikomiNaiyo;

    TorikomiConditions(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        this.div = div;
    }

    TorikomiTaishoData get取込対象データ() {
        if (torikomiTaisho == null) {
            torikomiTaisho = TorikomiTaishoData.toValue(BusinessConfig.get(ConfigNameDBE.モバイル審査会使用有無, SubGyomuCode.DBE認定支援));
        }
        return torikomiTaisho;
    }

    TorikomiNaiyo get取込内容() {
        if (torikomiNaiyo == null) {
            torikomiNaiyo = (div.getRadTorikomiNaiyo().getSelectedKey().contains(SELECT_KEY0))
                    ? TorikomiNaiyo._1_5次判定
                    : TorikomiNaiyo.審査結果;
        }
        return torikomiNaiyo;
    }

    RString get審査員出欠取込区分() {
        return RSTRING_1;
    }

    enum TorikomiNaiyo {

        /**
         * 1.5次判定
         */
        _1_5次判定("1"),
        /**
         * 審査結果
         */
        審査結果("2");

        private final RString aCode;

        private TorikomiNaiyo(String code) {
            this.aCode = new RString(code);
        }

        RString code() {
            return this.aCode;
        }
    }

    enum TorikomiTaishoData {

        /**
         * モバイル審査会
         */
        モバイル審査会("1"),
        /**
         * 認定ソフト
         */
        認定ソフト("2");

        private final RString aCode;

        private TorikomiTaishoData(String code) {
            this.aCode = new RString(code);
        }

        RString code() {
            return this.aCode;
        }

        boolean isMobile() {
            return this == モバイル審査会;
        }

        boolean isNinteiSoft() {
            return this == 認定ソフト;
        }

        private static TorikomiTaishoData toValue(RString code) {
            if (Objects.equals(モバイル審査会.aCode, code)) {
                return モバイル審査会;
            }
            return 認定ソフト;
        }
    }
}
