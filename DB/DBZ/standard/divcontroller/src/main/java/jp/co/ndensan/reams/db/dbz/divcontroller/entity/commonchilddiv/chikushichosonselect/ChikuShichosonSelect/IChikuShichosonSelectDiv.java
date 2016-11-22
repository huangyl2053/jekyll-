package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 *　@reamsid_L DBB-5720-010 xuxin
 */
public interface IChikuShichosonSelectDiv extends ICommonChildDivBaseProperties {

    void initialize();

    RString get選択対象();

    Map<RString, RString> get選択結果();

    RString get市町村コード();

    RString get市町村名称();

    RString get旧市町村コード();

    RString get旧市町村名称();

    RString get導入形態コード();

    void set選択対象(RString 選択対象);

    void set選択結果(Map<RString, RString> 選択結果);

    void set市町村コード(RString 市町村コード);

    void set旧市町村コード(RString 旧市町村コード);

    void initialize(Code 導入形態コード);

    void onChange_選択対象DDL();
}
