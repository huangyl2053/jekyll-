/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.sikakujiyushutoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakujiyushutoku.ShikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbz.business.config.ConfigValueBoolean;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * DBUMN00000_資格事由取得のカラスです。
 */
public class SikakuJiyuShutoku {

    private static final RString コード種別_0126 = new RString("0126");
    private static final RString オプションコード_1 = new RString("1");

    /**
     * コードマスタから資格事由のコードと略称を取得する。
     *
     * @param codeShubetsu コード種別
     * @param kijunbi 基準日
     * @param dounyuKeitaiCode 導入形態コード
     * @param gappeiJohoKubun 合併情報区分
     * @return 資格事由取得List
     */
    public List<ShikakuJiyuShutoku> shikakuJiyuShutoku(CodeShubetsu codeShubetsu, FlexibleDate kijunbi,
            RString dounyuKeitaiCode, RString gappeiJohoKubun) {

        List<ShikakuJiyuShutoku> 資格事由取得List = new ArrayList<>();

        if (!new CodeShubetsu(コード種別_0126).equals(codeShubetsu)) {

            List<UzT0007CodeEntity> codeMasterlist = CodeMaster.getCode(codeShubetsu, kijunbi);
            if (codeMasterlist != null && !codeMasterlist.isEmpty()) {
                for (UzT0007CodeEntity list : codeMasterlist) {
                    ShikakuJiyuShutoku shikakuJiyuShutoku = new ShikakuJiyuShutoku();
                    shikakuJiyuShutoku.setCode(list.getコード());
                    shikakuJiyuShutoku.setCodeRyakusho(list.getコード略称());
                    資格事由取得List.add(shikakuJiyuShutoku);

                }
            } else {
                return 資格事由取得List;
            }
        } else {

            List<UzT0007CodeEntity> codeMasterlist = CodeMaster.getCode(codeShubetsu, kijunbi);
            if (codeMasterlist != null && !codeMasterlist.isEmpty()) {
                for (UzT0007CodeEntity list : codeMasterlist) {

                    ShikakuJiyuShutoku 資格事由 = 資格事由取得(list, dounyuKeitaiCode, gappeiJohoKubun);
                    資格事由取得List.add(資格事由);
                }
            } else {
                return 資格事由取得List;
            }
        }
        return 資格事由取得List;
    }

    private ShikakuJiyuShutoku 資格事由取得(UzT0007CodeEntity list, RString dounyuKeitaiCode, RString gappeiJohoKubun) {

        ShikakuJiyuShutoku shikakuJiyuShutoku = new ShikakuJiyuShutoku();
        if ((DonyukeitaiCode.事務構成市町村.getCode().equals(dounyuKeitaiCode)
                || DonyukeitaiCode.事務単一.getCode().equals(dounyuKeitaiCode))
                && !ConfigValueBoolean.parseBoolean(gappeiJohoKubun)
                && オプションコード_1.equals(list.getオプション１())) {

            shikakuJiyuShutoku.setCode(list.getコード());
            shikakuJiyuShutoku.setCodeRyakusho(list.getコード略称());
        }
        if (DonyukeitaiCode.事務広域.getCode().equals(dounyuKeitaiCode)
                && !ConfigValueBoolean.parseBoolean(gappeiJohoKubun)
                && オプションコード_1.equals(list.getオプション２())) {

            shikakuJiyuShutoku.setCode(list.getコード());
            shikakuJiyuShutoku.setCodeRyakusho(list.getコード略称());
        }
        if ((DonyukeitaiCode.事務構成市町村.getCode().equals(dounyuKeitaiCode)
                || DonyukeitaiCode.事務単一.getCode().equals(dounyuKeitaiCode))
                && ConfigValueBoolean.parseBoolean(gappeiJohoKubun)
                && (オプションコード_1.equals(list.getオプション１())
                || オプションコード_1.equals(list.getオプション３()))) {

            shikakuJiyuShutoku.setCode(list.getコード());
            shikakuJiyuShutoku.setCodeRyakusho(list.getコード略称());
        }
        if (DonyukeitaiCode.事務広域.getCode().equals(dounyuKeitaiCode)
                && ConfigValueBoolean.parseBoolean(gappeiJohoKubun)
                && (オプションコード_1.equals(list.getオプション２())
                || オプションコード_1.equals(list.getオプション３()))) {

            shikakuJiyuShutoku.setCode(list.getコード());
            shikakuJiyuShutoku.setCodeRyakusho(list.getコード略称());
        }
        return shikakuJiyuShutoku;
    }
}
