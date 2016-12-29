package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Dec 28 15:27:58 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgImageMaskingTaisho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgImageMaskingTaisho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">

    private RString imageName;
    private RString hasMask;
    private RString state;
    private RString imagePath;
    private RString maskImagePath;
    private RString editImagePath;

    public dgImageMaskingTaisho_Row() {
        super();
        this.imageName = RString.EMPTY;
        this.hasMask = RString.EMPTY;
        this.state = RString.EMPTY;
        this.imagePath = RString.EMPTY;
        this.maskImagePath = RString.EMPTY;
        this.editImagePath = RString.EMPTY;
        this.setOriginalData("imageName", imageName);
        this.setOriginalData("hasMask", hasMask);
        this.setOriginalData("state", state);
        this.setOriginalData("imagePath", imagePath);
        this.setOriginalData("maskImagePath", maskImagePath);
        this.setOriginalData("editImagePath", editImagePath);
    }

    public dgImageMaskingTaisho_Row(RString imageName, RString hasMask, RString state, RString imagePath, RString maskImagePath, RString editImagePath) {
        super();
        this.setOriginalData("imageName", imageName);
        this.setOriginalData("hasMask", hasMask);
        this.setOriginalData("state", state);
        this.setOriginalData("imagePath", imagePath);
        this.setOriginalData("maskImagePath", maskImagePath);
        this.setOriginalData("editImagePath", editImagePath);
        this.imageName = imageName;
        this.hasMask = hasMask;
        this.state = state;
        this.imagePath = imagePath;
        this.maskImagePath = maskImagePath;
        this.editImagePath = editImagePath;
    }

    public RString getImageName() {
        return imageName;
    }

    public RString getHasMask() {
        return hasMask;
    }

    public RString getState() {
        return state;
    }

    public RString getImagePath() {
        return imagePath;
    }

    public RString getMaskImagePath() {
        return maskImagePath;
    }

    public RString getEditImagePath() {
        return editImagePath;
    }

    public void setImageName(RString imageName) {
        this.setOriginalData("imageName", imageName);
        this.imageName = imageName;
    }

    public void setHasMask(RString hasMask) {
        this.setOriginalData("hasMask", hasMask);
        this.hasMask = hasMask;
    }

    public void setState(RString state) {
        this.setOriginalData("state", state);
        this.state = state;
    }

    public void setImagePath(RString imagePath) {
        this.setOriginalData("imagePath", imagePath);
        this.imagePath = imagePath;
    }

    public void setMaskImagePath(RString maskImagePath) {
        this.setOriginalData("maskImagePath", maskImagePath);
        this.maskImagePath = maskImagePath;
    }

    public void setEditImagePath(RString editImagePath) {
        this.setOriginalData("editImagePath", editImagePath);
        this.editImagePath = editImagePath;
    }

    // </editor-fold>
}
